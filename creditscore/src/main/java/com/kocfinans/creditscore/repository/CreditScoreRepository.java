package com.kocfinans.creditscore.repository;

import com.kocfinans.creditscore.entity.CreditScore;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CreditScoreRepository extends MongoRepository<CreditScore, UUID> {

    CreditScore findByNationalIdentityId(String code);
}
