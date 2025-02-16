package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.TeacherPersonalProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPersonalProfileRepository extends JpaRepository<TeacherPersonalProfile, Long> {
}
