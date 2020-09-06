package com.kocfinans.loanapplication.entity;

import com.kocfinans.loanapplication.dto.LoanApplicationResponseStatus;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class LoanApplicationQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long queryId;
    private long loanLimit;
    private String nationalIdentityId;
    private Date applicationDate;
    private LoanApplicationResponseStatus applicationStatus;



}
