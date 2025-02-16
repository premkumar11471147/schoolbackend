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
    public List<ReportCard> getReportCardByStudentId(Long studentId) {
        return reportCardRepository.findByStudent_StudentId(studentId);
    }

    // Get Report Card by Report Student ID (Primary Key)
    public Optional<ReportCard> getReportCardById(Long reportStudentId) {
        return reportCardRepository.findById(reportStudentId);
    }

    // Delete Report Card by ID
    public void deleteReportCard(Long reportStudentId) {
        if (reportCardRepository.existsById(reportStudentId)) {
            reportCardRepository.deleteById(reportStudentId);
        } else {
            throw new RuntimeException("Report card not found with ID: " + reportStudentId);
        }
    }
}
