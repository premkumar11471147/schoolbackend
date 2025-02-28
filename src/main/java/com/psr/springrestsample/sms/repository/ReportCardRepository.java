package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.ReportCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCardModel, Long> {

    // Custom Query to fetch report card by studentId
    List<ReportCardModel> findByStudent_StudentId(Long studentId);
}
