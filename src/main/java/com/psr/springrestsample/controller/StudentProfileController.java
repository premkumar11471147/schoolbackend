package com.psr.springrestsample.controller;

import com.psr.springrestsample.model.StudentProfileModel;
import com.psr.springrestsample.service.StudentProfileService;
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
	public ResponseEntity<StudentProfileModel> addStudent(@RequestBody StudentProfileModel studentProfile) {
		System.out.println("Received Student Profile: " + studentProfile);

		if (studentProfile.getAdmissionId() == null) {
			return ResponseEntity.badRequest().body(null);
		}

		StudentProfileModel savedStudent = studentProfileService.saveStudentProfile(studentProfile);
		return ResponseEntity.ok(savedStudent);
	}


	@GetMapping
	public ResponseEntity<List<StudentProfileModel>> getAllStudents() {
		return ResponseEntity.ok(studentProfileService.getAllStudents());
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<StudentProfileModel> getStudentById(@PathVariable Long studentId) {
		Optional<StudentProfileModel> studentProfile = studentProfileService.getStudentById(studentId);
		return studentProfile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
		studentProfileService.deleteStudent(studentId);
		return ResponseEntity.noContent().build();
	}
}
