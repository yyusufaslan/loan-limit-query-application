package com.kocfinans.creditscore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "creditscore")
@Data
public class CreditScore {

    private String nationalIdentityId;
    private long score;
}
