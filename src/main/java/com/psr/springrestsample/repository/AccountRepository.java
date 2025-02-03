package com.psr.springrestsample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.psr.springrestsample.model.Account;

@Component
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account>  findByEmail(String email);

}
    
