package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.HomeworkModel;
import com.psr.springrestsample.sms.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    // Add or Update Homework
    @PostMapping
    public ResponseEntity<HomeworkModel> addHomework(@RequestBody HomeworkModel homework) {
        return ResponseEntity.ok(homeworkService.saveHomework(homework));
    }

    // Get All Homework Assignments
    @GetMapping
    public ResponseEntity<List<HomeworkModel>> getAllHomework() {
        return ResponseEntity.ok(homeworkService.getAllHomework());
    }

    // Get Homework by Date
    @GetMapping("/{date}")
    public ResponseEntity<HomeworkModel> getHomeworkByDate(@PathVariable String date) {
        Optional<HomeworkModel> homework = homeworkService.getHomeworkByDate(date);
        return homework.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Homework
    @DeleteMapping("/{date}")
    public ResponseEntity<Void> deleteHomework(@PathVariable String date) {
        homeworkService.deleteHomework(date);
        return ResponseEntity.noContent().build();
    }
}

