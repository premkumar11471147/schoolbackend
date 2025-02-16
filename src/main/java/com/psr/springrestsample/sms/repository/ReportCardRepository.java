package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportCardRepository extends JpaRepository<ReportCard, Long> {

    // Custom Query to fetch report card by studentId
    List<ReportCard> findByStudent_StudentId(Long studentId);
}
