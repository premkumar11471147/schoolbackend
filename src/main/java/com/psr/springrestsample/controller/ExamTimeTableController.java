package com.psr.springrestsample.controller;


import com.psr.springrestsample.model.ExamTimeTableModel;
import com.psr.springrestsample.service.ExamTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exam-time-table")
public class ExamTimeTableController {

    @Autowired
    private ExamTimeTableService examTimeTableService;

    // Add or Update Exam Time Table
    @PostMapping
    public ResponseEntity<ExamTimeTableModel> addExamTimeTable(@RequestBody ExamTimeTableModel examTimeTable) {
        return ResponseEntity.ok(examTimeTableService.saveExamTimeTable(examTimeTable));
    }

    // Get All Exam Time Tables
    @GetMapping
    public ResponseEntity<List<ExamTimeTableModel>> getAllExamTimeTables() {
        return ResponseEntity.ok(examTimeTableService.getAllExamTimeTables());
    }

    // Get Exam Time Table by ID
    @GetMapping("/{examId}")
    public ResponseEntity<ExamTimeTableModel> getExamTimeTableById(@PathVariable Long examId) {
        Optional<ExamTimeTableModel> examTimeTable = examTimeTableService.getExamTimeTableById(examId);
        return examTimeTable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Exam Time Table
    @DeleteMapping("/{examId}")
    public ResponseEntity<Void> deleteExamTimeTable(@PathVariable Long examId) {
        examTimeTableService.deleteExamTimeTable(examId);
        return ResponseEntity.noContent().build();
    }
}
