package com.psr.springrestsample.controller;


import com.psr.springrestsample.model.ReportCardModel;
import com.psr.springrestsample.service.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report-cards")
public class ReportCardController {


    @Autowired
    private ReportCardService reportCardService;

    // Add or Update Report Card
    @PostMapping
    public ResponseEntity<ReportCardModel> addReportCard(@RequestBody ReportCardModel reportCard) {
        return ResponseEntity.ok(reportCardService.saveReportCard(reportCard));
    }

    // Get All Report Cards
    @GetMapping
    public ResponseEntity<List<ReportCardModel>> getAllReportCards() {
        return ResponseEntity.ok(reportCardService.getAllReportCards());
    }



    // Get Report Card by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ReportCardModel>> getReportCardByStudentId(@PathVariable Long studentId) {
        List<ReportCardModel> reportCards = reportCardService.getReportCardByStudentId(studentId);
        if (reportCards.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reportCards);
    }

    // Delete Report Card
    @DeleteMapping("/{reportStudentId}")
    public ResponseEntity<Void> deleteReportCard(@PathVariable Long reportStudentId) {
        reportCardService.deleteReportCard(reportStudentId);
        return ResponseEntity.noContent().build();
    }
}

