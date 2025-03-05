package com.psr.springrestsample.service;

import com.psr.springrestsample.model.ClassTeacherJunctionModel;
import com.psr.springrestsample.repository.ClassTeacherJunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClassTeacherJunctionService {

    @Autowired
    private ClassTeacherJunctionRepository classTeacherJunctionRepository;

    // Assign Teacher to a Class
    public ClassTeacherJunctionModel assignTeacherToClass(ClassTeacherJunctionModel classTeacherJunction) {
        return classTeacherJunctionRepository.save(classTeacherJunction);
    }

    // Get All Assignments
    public List<ClassTeacherJunctionModel> getAllAssignments() {
        return classTeacherJunctionRepository.findAll();
    }

    // Get Assignment by ID
    public Optional<ClassTeacherJunctionModel> getAssignmentById(Long id) {
        return classTeacherJunctionRepository.findById(id);
    }

    // Delete Assignment
    public void removeAssignment(Long id) {
        classTeacherJunctionRepository.deleteById(id);
    }
}

