package com.kocfinans.loanapplication.repository;

import com.kocfinans.loanapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByNationalIdentityId(String nationalIdentityId);

}
