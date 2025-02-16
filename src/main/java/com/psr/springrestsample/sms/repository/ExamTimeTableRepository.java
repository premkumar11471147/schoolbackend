package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.ExamTimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTimeTableRepository extends JpaRepository<ExamTimeTable, Long> {
}
