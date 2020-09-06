package com.kocfinans.notificationservice.dto;

import com.kocfinans.notificationservice.model.NotificationCode;
import lombok.Data;

@Data
public class NotificationRequestDto {

    private String notificationCode;
    private String nationalIdentityId;
    private long loanLimit;
}
