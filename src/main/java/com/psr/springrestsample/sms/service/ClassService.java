package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.ClassEntity;
import com.psr.springrestsample.sms.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    // Add or Update Class
    public ClassEntity saveClass(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }

    // Get All Classes
    public List<ClassEntity> getAllClasses() {
        return classRepository.findAll();
    }

    // Get Class by ID
    public Optional<ClassEntity> getClassById(Long classId) {
        return classRepository.findById(classId);
    }

    // Delete Class
    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }
}
