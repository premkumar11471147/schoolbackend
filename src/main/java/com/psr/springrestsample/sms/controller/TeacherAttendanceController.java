package com.psr.springrestsample.sms.controller;

import com.psr.springrestsample.sms.model.TeacherAttendanceModel;
import com.psr.springrestsample.sms.service.TeacherAttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendance")
public class TeacherAttendanceController {

    private final TeacherAttendanceService teacherAttendanceService;

    public TeacherAttendanceController(TeacherAttendanceService teacherAttendanceService) {
        this.teacherAttendanceService = teacherAttendanceService;
    }

    // Create Attendance Record
    @PostMapping
    public ResponseEntity<TeacherAttendanceModel> createAttendance(@RequestBody TeacherAttendanceModel attendance) {
        return ResponseEntity.ok(teacherAttendanceService.saveAttendance(attendance));
    }

    // Get All Attendance Records
    @GetMapping
    public ResponseEntity<List<TeacherAttendanceModel>> getAllAttendance() {
        return ResponseEntity.ok(teacherAttendanceService.getAllAttendance());
    }

    // Get Attendance by ID
    @GetMapping("/{attendanceId}")
    public ResponseEntity<Optional<TeacherAttendanceModel>> getAttendanceById(@PathVariable Long attendanceId) {
        return ResponseEntity.ok(teacherAttendanceService.getAttendanceById(attendanceId));
    }

    // Get Attendance by Teacher ID
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<TeacherAttendanceModel>> getAttendanceByTeacherId(@PathVariable Long teacherId) {
        return ResponseEntity.ok(teacherAttendanceService.getAttendanceByTeacherId(teacherId));
    }

    // Update Attendance Record
    @PutMapping("/{attendanceId}")
    public ResponseEntity<TeacherAttendanceModel> updateAttendance(@PathVariable Long attendanceId, @RequestBody TeacherAttendanceModel updatedAttendance) {
        return ResponseEntity.ok(teacherAttendanceService.updateAttendance(attendanceId, updatedAttendance));
    }

    // Delete Attendance Record
    @DeleteMapping("/{attendanceId}")
    public ResponseEntity<String> deleteAttendance(@PathVariable Long attendanceId) {
        teacherAttendanceService.deleteAttendance(attendanceId);
        return ResponseEntity.ok("Attendance record deleted successfully");
    }
}
