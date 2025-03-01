package com.psr.springrestsample.sms.controller;
import com.psr.springrestsample.sms.model.StudentAttendanceModel;
import com.psr.springrestsample.sms.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance/student")
public class StudentAttendanceController {

    @Autowired
    private StudentAttendanceService attendanceService;

    // Add or Update Attendance
    @PostMapping
    public ResponseEntity<StudentAttendanceModel> addAttendance(@RequestBody StudentAttendanceModel attendance) {
        return ResponseEntity.ok(attendanceService.saveAttendance(attendance));
    }

    // Get All Attendance Records
    @GetMapping
    public ResponseEntity<List<StudentAttendanceModel>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }

    // Get Attendance by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentAttendanceModel>> getAttendanceByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(attendanceService.getAttendanceByStudent(studentId));
    }

    // Get Attendance by Date
    @GetMapping("/date/{date}")
    public ResponseEntity<List<StudentAttendanceModel>> getAttendanceByDate(@PathVariable String date) {
        return ResponseEntity.ok(attendanceService.getAttendanceByDate(LocalDate.parse(date)));
    }

    // Get Attendance by ID
    @GetMapping("/{attendanceId}")
    public ResponseEntity<StudentAttendanceModel> getAttendanceById(@PathVariable Long attendanceId) {
        Optional<StudentAttendanceModel> attendance = attendanceService.getAttendanceById(attendanceId);
        return attendance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Attendance
    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long attendanceId) {
        attendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.noContent().build();
    }
}
