package com.psr.springrestsample.sms.controller;

import com.psr.springrestsample.sms.model.ClassTeacherJunction;
import com.psr.springrestsample.sms.service.ClassTeacherJunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/class-teacher-junction")
public class ClassTeacherJunctionController {

    @Autowired
    private ClassTeacherJunctionService classTeacherJunctionService;

    // Assign Teacher to a Class
    @PostMapping
    public ResponseEntity<ClassTeacherJunction> assignTeacherToClass(@RequestBody ClassTeacherJunction classTeacherJunction) {
        return ResponseEntity.ok(classTeacherJunctionService.assignTeacherToClass(classTeacherJunction));
    }

    // Get All Assignments
    @GetMapping
    public ResponseEntity<List<ClassTeacherJunction>> getAllAssignments() {
        return ResponseEntity.ok(classTeacherJunctionService.getAllAssignments());
    }

    // Get Assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassTeacherJunction> getAssignmentById(@PathVariable Long id) {
        Optional<ClassTeacherJunction> assignment = classTeacherJunctionService.getAssignmentById(id);
        return assignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Remove Assignment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAssignment(@PathVariable Long id) {
        classTeacherJunctionService.removeAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
