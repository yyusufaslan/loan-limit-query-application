package com.kocfinans.notificationservice.core.sms;

import com.kocfinans.notificationservice.core.Notification;
import com.kocfinans.notificationservice.dto.NotificationRequestDto;
import com.kocfinans.notificationservice.model.NotificationCode;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationApproveSMS implements Notification {
    @Override
    public String createBody(NotificationRequestDto request) {
        return request.getNationalIdentityId() + " T.C kimlik numaranız ile yaptığınız başvurunuz onaylanmıştır. Onaylanan limitiniz :" + request.getLoanLimit();
    }

    @Override
    public NotificationCode getCode() {
        return NotificationCode.SMS_LOAN_APPLICATION_APPROVE;
    }
}
