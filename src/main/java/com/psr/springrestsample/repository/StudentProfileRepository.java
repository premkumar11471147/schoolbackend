package com.psr.springrestsample.repository;

import com.psr.springrestsample.model.StudentProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfileModel, Long> {
}
