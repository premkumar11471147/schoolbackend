package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.ClassEntity;
import com.psr.springrestsample.sms.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    // Add or Update Class
    @PostMapping()
    public ResponseEntity<ClassEntity> addClass(@RequestBody ClassEntity classEntity) {
        ClassEntity savedClass = classService.saveClass(classEntity);
        return ResponseEntity.ok(savedClass);
    }

    // Get All Classes
    @GetMapping
    public ResponseEntity<List<ClassEntity>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    // Get Class by ID
    @GetMapping("/{classId}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Long classId) {
        Optional<ClassEntity> classEntity = classService.getClassById(classId);
        return classEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Class
    @DeleteMapping("/{classId}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long classId) {
        classService.deleteClass(classId);
        return ResponseEntity.noContent().build();
    }
}
