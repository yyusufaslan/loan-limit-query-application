package com.kocfinans.creditscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing(modifyOnCreate=false)
@EnableMongoRepositories
public class CreditscoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditscoreApplication.class, args);
    }

}
