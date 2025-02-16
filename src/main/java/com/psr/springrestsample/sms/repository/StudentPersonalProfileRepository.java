package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.StudentPersonalProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPersonalProfileRepository extends JpaRepository<StudentPersonalProfile, Long> {
}
