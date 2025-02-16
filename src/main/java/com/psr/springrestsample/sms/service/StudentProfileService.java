package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.StudentPersonalProfile;
import com.psr.springrestsample.sms.model.StudentProfile;
import com.psr.springrestsample.sms.repository.StudentProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Transactional
    public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
        if (studentProfile.getStudentPersonalProfile() != null) {
            studentProfile.getStudentPersonalProfile().setStudentProfile(studentProfile);
        }
        return studentProfileRepository.save(studentProfile);
    }

    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    public Optional<StudentProfile> getStudentById(Long studentId) {
        return studentProfileRepository.findById(studentId);
    }

    public void deleteStudent(Long studentId) {
        studentProfileRepository.deleteById(studentId);
    }
}
