package com.kocfinans.loanapplication.repository;

import com.kocfinans.loanapplication.entity.LoanApplicationQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoanApplicationQueryRepository extends JpaRepository<LoanApplicationQuery, UUID> {
}
