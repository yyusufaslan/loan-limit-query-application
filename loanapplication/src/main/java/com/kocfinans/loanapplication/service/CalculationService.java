package com.kocfinans.loanapplication.service;

import com.kocfinans.loanapplication.LoanApplication;
import com.kocfinans.loanapplication.dto.LoanApplicationRequest;
import com.kocfinans.loanapplication.dto.LoanApplicationResponse;
import com.kocfinans.loanapplication.dto.LoanApplicationResponseStatus;
import com.kocfinans.loanapplication.dto.NotificationRequestDto;
import com.kocfinans.loanapplication.entity.LoanApplicationQuery;
import com.kocfinans.loanapplication.entity.User;
import com.kocfinans.loanapplication.repository.LoanApplicationQueryRepository;
import com.kocfinans.loanapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Objects;


@Service
public class CalculationService {

    private static final long creditLimitMultiplier = 4;
    private static final Logger logger = LogManager.getLogger(CalculationService.class);


    @Autowired
    CreditScoreClient creditScoreClient;
    @Autowired
    NotificationClient notificationClient;
    @Autowired
    LoanApplicationQueryRepository loanApplicationQueryRepository;
    @Autowired
    UserRepository userRepository;

    public LoanApplicationResponse calculateLoanScore(LoanApplicationRequest loanApplicationRequest) {
        logger.info(loanApplicationRequest.getNationalIdentityId() + " T.C numarası ile kredi başvurusu gönderildi.");
        long creditScore = creditScoreClient.getCreditScoreByUserIdentifier(loanApplicationRequest.getNationalIdentityId());
        return calculateLoanLimit(loanApplicationRequest, creditScore);
    }

    private LoanApplicationResponse calculateLoanLimit(LoanApplicationRequest loanApplicationRequest, long creditScore) {
        LoanApplicationResponse loanApplicationResponse = new LoanApplicationResponse();
        if (creditScore == 0){
            loanApplicationResponse.setResponseMessage("Kredi skoru kaydınız bulunmamaktadır.");
            loanApplicationResponse.setLoanLimit(0);
            loanApplicationResponse.setNotificationStatus(false);
            loanApplicationResponse.setStatus(LoanApplicationResponseStatus.DISAPPROVE);
            return loanApplicationResponse;
        }
        if (creditScore < 500) {
            loanApplicationResponse.setStatus(LoanApplicationResponseStatus.DISAPPROVE);
            loanApplicationResponse.setLoanLimit(0);
            loanApplicationResponse.setResponseMessage("Kredi limit sorgunuz reddedilmiştir...");
        }else if (creditScore < 1000 && loanApplicationRequest.getMonthlySalary() < 5000){
            loanApplicationResponse.setStatus(LoanApplicationResponseStatus.APPROVE);
            loanApplicationResponse.setLoanLimit(10000);
            loanApplicationResponse.setResponseMessage("Kredi limit sorgunuz onaylanmıştır...");
        }else {
            loanApplicationResponse.setStatus(LoanApplicationResponseStatus.APPROVE);
            loanApplicationResponse.setLoanLimit(loanApplicationRequest.getMonthlySalary() * creditLimitMultiplier);
            loanApplicationResponse.setResponseMessage("Kredi limit sorgunuz onaylanmıştır...");
        }
        LoanApplicationQuery loanApplicationQuery = saveLoanApplication(loanApplicationResponse,loanApplicationRequest);

        logger.info(loanApplicationRequest.getNationalIdentityId() + " T.C numarası ile kredi başvurusu sonucu :" + loanApplicationQuery.getApplicationStatus().toString());
        return sendNotification(loanApplicationResponse,loanApplicationRequest);
    }

    private LoanApplicationQuery saveLoanApplication(LoanApplicationResponse loanApplicationResponse, LoanApplicationRequest loanApplicationRequest) {
        LoanApplicationQuery loanApplicationQuery = new LoanApplicationQuery();

        loanApplicationQuery.setApplicationDate(new Date());
        loanApplicationQuery.setApplicationStatus(loanApplicationResponse.getStatus());
        loanApplicationQuery.setLoanLimit(loanApplicationResponse.getLoanLimit());
        loanApplicationQuery.setNationalIdentityId(loanApplicationRequest.getNationalIdentityId());

        saveUser(loanApplicationRequest);
        loanApplicationQueryRepository.save(loanApplicationQuery);

        return loanApplicationQuery;
    }

    private void saveUser(LoanApplicationRequest loanApplicationRequest) {
        User user1 = userRepository.findByNationalIdentityId(loanApplicationRequest.getNationalIdentityId());
        if (Objects.isNull(user1)){
            User newUser = new User();
            newUser.setMonthlySalary(loanApplicationRequest.getMonthlySalary());
            newUser.setName(loanApplicationRequest.getName());
            newUser.setSurname(loanApplicationRequest.getSurname());
            newUser.setNationalIdentityId(loanApplicationRequest.getNationalIdentityId());
            newUser.setPhoneNumber(loanApplicationRequest.getPhoneNumber());
            userRepository.save(newUser);
        }
    }

    private LoanApplicationResponse sendNotification(LoanApplicationResponse loanApplicationResponse, LoanApplicationRequest loanApplicationRequest) {
        NotificationRequestDto notificationRequestDto = createNotificationRequest(loanApplicationResponse,loanApplicationRequest);

        logger.info(loanApplicationRequest.getNationalIdentityId() + " T.C numarası ile kredi başvurusu sonucu :" + loanApplicationResponse.getStatus().toString());

        boolean notificationStatus = notificationClient.sendNotification(notificationRequestDto);
        loanApplicationResponse.setNotificationStatus(notificationStatus);

        return loanApplicationResponse;
    }

    private NotificationRequestDto createNotificationRequest(LoanApplicationResponse loanApplicationResponse, LoanApplicationRequest loanApplicationRequest) {
        NotificationRequestDto notificationRequestDto = new NotificationRequestDto();

        String notificationCode =
                (loanApplicationResponse.getStatus().toString().equals(LoanApplicationResponseStatus.APPROVE))
                        ? "SMS_LOAN_APPLICATION_APPROVE" : "SMS_LOAN_APPLICATION_DISAPPROVE";

        notificationRequestDto.setNationalIdentityId(loanApplicationRequest.getNationalIdentityId());
        notificationRequestDto.setNotificationCode(notificationCode);
        notificationRequestDto.setLoanLimit(loanApplicationResponse.getLoanLimit());
        return notificationRequestDto;
    }

}
