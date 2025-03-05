package com.psr.springrestsample.repository;

import com.psr.springrestsample.model.TeacherPersonalProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPersonalProfileRepository extends JpaRepository<TeacherPersonalProfileModel, Long> {
}
