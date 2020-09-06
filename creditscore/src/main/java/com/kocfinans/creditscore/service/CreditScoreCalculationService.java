package com.kocfinans.creditscore.service;

import com.kocfinans.creditscore.entity.CreditScore;
import com.kocfinans.creditscore.repository.CreditScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Service
public class CreditScoreCalculationService {

    private static final Logger logger = LogManager.getLogger(CreditScoreCalculationService.class);

    @Autowired
    CreditScoreRepository creditScoreRepository;

    public long creditScoreCalculate(String nationalIdentityId) {

        logger.info(nationalIdentityId + "T.C numarası ile kredi sorgusu gönderildi.");

        CreditScore creditScore = creditScoreRepository.findByNationalIdentityId(nationalIdentityId);
        if (Objects.isNull(creditScore)){
            logger.info(nationalIdentityId + "T.C numarası ile kullanıcı bulunamadı.." );
            return 0;
        }else {
            logger.info(nationalIdentityId + "T.C numarası ile kredi sorgusu " +
                    creditScore.getScore() + " değeri ile başarılı cevap verildi.");
            return creditScore.getScore();
        }
    }
}
