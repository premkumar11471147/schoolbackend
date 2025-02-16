package com.psr.springrestsample.sms.controller;

import com.psr.springrestsample.sms.DTO.TeacherDto;
import com.psr.springrestsample.sms.model.TeacherPersonalProfile;
import com.psr.springrestsample.sms.model.TeacherProfile;
import com.psr.springrestsample.sms.service.TeacherProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
public class TeacherProfileController {

    @Autowired
    private TeacherProfileService teacherProfileService;

    // Add Teacher with Personal Details
    @PostMapping
    public ResponseEntity<TeacherProfile> addTeacher(@RequestBody TeacherDto request) {
        TeacherProfile savedTeacher = teacherProfileService.saveTeacherProfile(request.getTeacherProfile(),
                request.getTeacherPersonalProfile());
        return ResponseEntity.ok(savedTeacher);
    }


    // Get All Teachers
    @GetMapping
    public ResponseEntity<List<TeacherProfile>> getAllTeachers() {
        return ResponseEntity.ok(teacherProfileService.getAllTeachers());
    }

    // Get Teacher by ID
    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherProfile> getTeacherById(@PathVariable Long teacherId) {
        Optional<TeacherProfile> teacherProfile = teacherProfileService.getTeacherById(teacherId);
        return teacherProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Teachers by School ID
    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<TeacherProfile>> getTeachersBySchoolId(@PathVariable Long schoolId) {
        return ResponseEntity.ok(teacherProfileService.getTeachersBySchoolId(schoolId));
    }

    // Delete Teacher
    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long teacherId) {
        teacherProfileService.deleteTeacher(teacherId);
        return ResponseEntity.noContent().build();
    }
}

