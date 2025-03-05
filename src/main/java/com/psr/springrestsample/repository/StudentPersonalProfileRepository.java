package com.psr.springrestsample.repository;

import com.psr.springrestsample.model.StudentPersonalProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPersonalProfileRepository extends JpaRepository<StudentPersonalProfileModel, Long> {
}
