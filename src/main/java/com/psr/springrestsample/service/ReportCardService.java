package com.psr.springrestsample.service;

import com.psr.springrestsample.model.ReportCardModel;
import com.psr.springrestsample.repository.ReportCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportCardService {

    @Autowired
    private ReportCardRepository reportCardRepository;

    // Add or Update Report Card
    public ReportCardModel saveReportCard(ReportCardModel reportCard) {
        return reportCardRepository.save(reportCard);
    }

    // Get All Report Cards
    public List<ReportCardModel> getAllReportCards() {
        return reportCardRepository.findAll();
    }

    // Get Report Card by Student ID
    public List<ReportCardModel> getReportCardByStudentId(Long studentId) {
        return reportCardRepository.findByStudent_StudentId(studentId);
    }

    // Get Report Card by Report Student ID (Primary Key)
    public Optional<ReportCardModel> getReportCardById(Long reportStudentId) {
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
