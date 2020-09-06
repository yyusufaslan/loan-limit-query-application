package com.kocfinans.loanapplication.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class User {

    @Id
    private long userId;
    private String nationalIdentityId;
    private String name;
    private String surname;
    private long monthlySalary;
    private String phoneNumber;


}
