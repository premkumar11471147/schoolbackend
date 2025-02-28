package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.HomeworkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkModel, String> {
}
