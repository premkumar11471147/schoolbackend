package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {
}
