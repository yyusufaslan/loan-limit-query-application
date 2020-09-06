package com.kocfinans.loanapplication.dto;

import lombok.Data;

@Data
public class NotificationRequestDto {

    private String notificationCode;
    private String nationalIdentityId;
    private long loanLimit;

}
