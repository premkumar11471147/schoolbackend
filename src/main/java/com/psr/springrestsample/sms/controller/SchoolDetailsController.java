package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.SchoolDetails;
import com.psr.springrestsample.sms.service.SchoolDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/school-details")
public class SchoolDetailsController {

    @Autowired
    private SchoolDetailsService schoolDetailsService;

    // Add or Update School Details
    @PostMapping
    public ResponseEntity<SchoolDetails> addSchoolDetails(@RequestBody SchoolDetails schoolDetails) {
        return ResponseEntity.ok(schoolDetailsService.saveSchoolDetails(schoolDetails));
    }

    // Get All School Details
    @GetMapping
    public ResponseEntity<List<SchoolDetails>> getAllSchoolDetails() {
        return ResponseEntity.ok(schoolDetailsService.getAllSchoolDetails());
    }

    // Get School Details by ID
    @GetMapping("/{schoolId}")
    public ResponseEntity<SchoolDetails> getSchoolDetailsById(@PathVariable Long schoolId) {
        Optional<SchoolDetails> schoolDetails = schoolDetailsService.getSchoolDetailsById(schoolId);
        return schoolDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete School Details
    @DeleteMapping("/{schoolId}")
    public ResponseEntity<Void> deleteSchoolDetails(@PathVariable Long schoolId) {
        schoolDetailsService.deleteSchoolDetails(schoolId);
        return ResponseEntity.noContent().build();
    }
}
