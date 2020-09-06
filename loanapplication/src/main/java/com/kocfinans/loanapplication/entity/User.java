package com.kocfinans.loanapplication.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nationalIdentityId;
    private String name;
    private String surname;
    private long monthlySalary;
    private String phoneNumber;


}
