package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.SchoolDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDetailsRepository extends JpaRepository<SchoolDetailsModel, Long> {
}

