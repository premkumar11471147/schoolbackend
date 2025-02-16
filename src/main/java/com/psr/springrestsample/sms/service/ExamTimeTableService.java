package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.ExamTimeTable;
import com.psr.springrestsample.sms.repository.ExamTimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamTimeTableService {

    @Autowired
    private ExamTimeTableRepository examTimeTableRepository;

    // Add or Update Exam Time Table
    public ExamTimeTable saveExamTimeTable(ExamTimeTable examTimeTable) {
        return examTimeTableRepository.save(examTimeTable);
    }

    // Get All Exam Time Tables
    public List<ExamTimeTable> getAllExamTimeTables() {
        return examTimeTableRepository.findAll();
    }

    // Get Exam Time Table by ID
    public Optional<ExamTimeTable> getExamTimeTableById(Long examId) {
        return examTimeTableRepository.findById(examId);
    }

    // Delete Exam Time Table
    public void deleteExamTimeTable(Long examId) {
        examTimeTableRepository.deleteById(examId);
    }
}
