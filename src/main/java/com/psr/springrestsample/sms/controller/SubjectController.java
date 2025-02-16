package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.Subject;
import com.psr.springrestsample.sms.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // Add or Update Subject
    @PostMapping
    public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.saveSubject(subject));
    }

    // Get All Subjects
    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    // Get Subject by ID
    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long subjectId) {
        Optional<Subject> subject = subjectService.getSubjectById(subjectId);
        return subject.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Subject
    @DeleteMapping("/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.noContent().build();
    }
}
