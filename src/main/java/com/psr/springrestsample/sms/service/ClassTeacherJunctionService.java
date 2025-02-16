package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.ClassTeacherJunction;
import com.psr.springrestsample.sms.repository.ClassTeacherJunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClassTeacherJunctionService {

    @Autowired
    private ClassTeacherJunctionRepository classTeacherJunctionRepository;

    // Assign Teacher to a Class
    public ClassTeacherJunction assignTeacherToClass(ClassTeacherJunction classTeacherJunction) {
        return classTeacherJunctionRepository.save(classTeacherJunction);
    }

    // Get All Assignments
    public List<ClassTeacherJunction> getAllAssignments() {
        return classTeacherJunctionRepository.findAll();
    }

    // Get Assignment by ID
    public Optional<ClassTeacherJunction> getAssignmentById(Long id) {
        return classTeacherJunctionRepository.findById(id);
    }

    // Delete Assignment
    public void removeAssignment(Long id) {
        classTeacherJunctionRepository.deleteById(id);
    }
}

