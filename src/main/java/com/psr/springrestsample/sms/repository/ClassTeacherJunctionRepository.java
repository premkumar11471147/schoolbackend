package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.ClassTeacherJunctionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTeacherJunctionRepository extends JpaRepository<ClassTeacherJunctionModel, Long> {
}

