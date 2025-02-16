package com.psr.springrestsample.sms.controller;


import com.psr.springrestsample.sms.model.TimeTable;
import com.psr.springrestsample.sms.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/time-tables")
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    // Add or Update Time Table
    @PostMapping
    public ResponseEntity<TimeTable> addTimeTable(@RequestBody TimeTable timeTable) {
        return ResponseEntity.ok(timeTableService.saveTimeTable(timeTable));
    }

    // Get All Time Tables
    @GetMapping
    public ResponseEntity<List<TimeTable>> getAllTimeTables() {
        return ResponseEntity.ok(timeTableService.getAllTimeTables());
    }

    // Get Time Table by ID
    @GetMapping("/{timeId}")
    public ResponseEntity<TimeTable> getTimeTableById(@PathVariable Long timeId) {
        Optional<TimeTable> timeTable = timeTableService.getTimeTableById(timeId);
        return timeTable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Time Table
    @DeleteMapping("/{timeId}")
    public ResponseEntity<Void> deleteTimeTable(@PathVariable Long timeId) {
        timeTableService.deleteTimeTable(timeId);
        return ResponseEntity.noContent().build();
    }
}

