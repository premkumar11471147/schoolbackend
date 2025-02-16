package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.ReportCard;
import com.psr.springrestsample.sms.repository.ReportCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportCardService {

    @Autowired
    private ReportCardRepository reportCardRepository;

    // Add or Update Report Card
    public ReportCard saveReportCard(ReportCard reportCard) {
        return reportCardRepository.save(reportCard);
    }

    // Get All Report Cards
    public List<ReportCard> getAllReportCards() {
        return reportCardRepository.findAll();
    }

    // Get Report Card by Student ID
    public Optional<ReportCard> getReportCardByStudentId(Long studentId) {
        return reportCardRepository.findById(studentId);
    }

    // Delete Report Card
    public void deleteReportCard(Long reportStudentId) {
        reportCardRepository.deleteById(reportStudentId);
    }
}

