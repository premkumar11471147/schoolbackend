package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
}
