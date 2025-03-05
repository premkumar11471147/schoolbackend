package com.psr.springrestsample.controller;


import com.psr.springrestsample.model.TimeTableModel;
import com.psr.springrestsample.service.TimeTableService;
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
    public ResponseEntity<TimeTableModel> addTimeTable(@RequestBody TimeTableModel timeTable) {
        return ResponseEntity.ok(timeTableService.saveTimeTable(timeTable));
    }

    // Get All Time Tables
    @GetMapping
    public ResponseEntity<List<TimeTableModel>> getAllTimeTables() {
        return ResponseEntity.ok(timeTableService.getAllTimeTables());
    }

    // Get Time Table by ID
    @GetMapping("/{timeId}")
    public ResponseEntity<TimeTableModel> getTimeTableById(@PathVariable Long timeId) {
        Optional<TimeTableModel> timeTable = timeTableService.getTimeTableById(timeId);
        return timeTable.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Time Table
    @DeleteMapping("/{timeId}")
    public ResponseEntity<Void> deleteTimeTable(@PathVariable Long timeId) {
        timeTableService.deleteTimeTable(timeId);
        return ResponseEntity.noContent().build();
    }
}

