package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.ClassTeacherJunctionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTeacherJunctionRepository extends JpaRepository<ClassTeacherJunctionModel, Long> {
}

