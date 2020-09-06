package com.kocfinans.loanapplication.dto;

import lombok.Data;

@Data
public class LoanApplicationResponse {

    private long loanLimit;
    private LoanApplicationResponseStatus status;
    private boolean notificationStatus;
    private String responseMessage;
}
