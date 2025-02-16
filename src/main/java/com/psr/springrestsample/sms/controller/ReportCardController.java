package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.ReportCard;
import com.psr.springrestsample.sms.service.ReportCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/report-cards")
public class ReportCardController {

    @Autowired
    private ReportCardService reportCardService;

    // Add or Update Report Card
    @PostMapping
    public ResponseEntity<ReportCard> addReportCard(@RequestBody ReportCard reportCard) {
        return ResponseEntity.ok(reportCardService.saveReportCard(reportCard));
    }

    // Get All Report Cards
    @GetMapping
    public ResponseEntity<List<ReportCard>> getAllReportCards() {
        return ResponseEntity.ok(reportCardService.getAllReportCards());
    }

    // Get Report Card by Student ID
    @GetMapping("/{studentId}")
    public ResponseEntity<ReportCard> getReportCardByStudentId(@PathVariable Long studentId) {
        Optional<ReportCard> reportCard = reportCardService.getReportCardByStudentId(studentId);
        return reportCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Report Card
    @DeleteMapping("/{reportStudentId}")
    public ResponseEntity<Void> deleteReportCard(@PathVariable Long reportStudentId) {
        reportCardService.deleteReportCard(reportStudentId);
        return ResponseEntity.noContent().build();
    }
}

