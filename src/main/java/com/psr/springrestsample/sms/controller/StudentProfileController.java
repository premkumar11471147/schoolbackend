package com.psr.springrestsample.sms.controller;

import com.psr.springrestsample.sms.model.StudentProfile;
import com.psr.springrestsample.sms.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentProfileController {

	@Autowired
	private StudentProfileService studentProfileService;

	@PostMapping
	public ResponseEntity<StudentProfile> addStudent(@RequestBody StudentProfile studentProfile) {
		System.out.println("Received Student Profile: " + studentProfile);

		if (studentProfile.getAdmissionId() == null) {
			return ResponseEntity.badRequest().body(null);
		}

		StudentProfile savedStudent = studentProfileService.saveStudentProfile(studentProfile);
		return ResponseEntity.ok(savedStudent);
	}


	@GetMapping
	public ResponseEntity<List<StudentProfile>> getAllStudents() {
		return ResponseEntity.ok(studentProfileService.getAllStudents());
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long studentId) {
		Optional<StudentProfile> studentProfile = studentProfileService.getStudentById(studentId);
		return studentProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
		studentProfileService.deleteStudent(studentId);
		return ResponseEntity.noContent().build();
	}
}
