package com.psr.springrestsample.sms.controller;

import com.psr.springrestsample.sms.model.Fees;
import com.psr.springrestsample.sms.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fees")
public class FeesController {

    @Autowired
    private FeesService feesService;

    // Add or Update Fees
    @PostMapping
    public ResponseEntity<Fees> addFees(@RequestBody Fees fees) {
        return ResponseEntity.ok(feesService.saveFees(fees));
    }

    // Get All Fees
    @GetMapping
    public ResponseEntity<List<Fees>> getAllFees() {
        return ResponseEntity.ok(feesService.getAllFees());
    }

    // Get Fees by ID
    @GetMapping("/{receiptId}")
    public ResponseEntity<Fees> getFeesById(@PathVariable Long receiptId) {
        Optional<Fees> fees = feesService.getFeesById(receiptId);
        return fees.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Fees
    @DeleteMapping("/{receiptId}")
    public ResponseEntity<Void> deleteFees(@PathVariable Long receiptId) {
        feesService.deleteFees(receiptId);
        return ResponseEntity.noContent().build();
    }
}
