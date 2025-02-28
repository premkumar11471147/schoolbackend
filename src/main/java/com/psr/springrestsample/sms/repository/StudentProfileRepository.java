package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.StudentProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfileModel, Long> {
}
