package com.psr.springrestsample.service;


import com.psr.springrestsample.model.ExamTimeTableModel;
import com.psr.springrestsample.repository.ExamTimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamTimeTableService {

    @Autowired
    private ExamTimeTableRepository examTimeTableRepository;

    // Add or Update Exam Time Table
    public ExamTimeTableModel saveExamTimeTable(ExamTimeTableModel examTimeTable) {
        return examTimeTableRepository.save(examTimeTable);
    }

    // Get All Exam Time Tables
    public List<ExamTimeTableModel> getAllExamTimeTables() {
        return examTimeTableRepository.findAll();
    }

    // Get Exam Time Table by ID
    public Optional<ExamTimeTableModel> getExamTimeTableById(Long examId) {
        return examTimeTableRepository.findById(examId);
    }

    // Delete Exam Time Table
    public void deleteExamTimeTable(Long examId) {
        examTimeTableRepository.deleteById(examId);
    }
}
