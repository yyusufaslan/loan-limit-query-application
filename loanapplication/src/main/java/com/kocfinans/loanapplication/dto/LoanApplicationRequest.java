package com.kocfinans.loanapplication.dto;

import lombok.Data;

@Data
public class LoanApplicationRequest {

    private String nationalIdentityId;
    private String name;
    private String surname;
    private long monthlySalary;
    private String phoneNumber;
}
