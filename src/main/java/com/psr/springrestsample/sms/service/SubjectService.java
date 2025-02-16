package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.Subject;
import com.psr.springrestsample.sms.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    // Add or Update Subject
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // Get All Subjects
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Get Subject by ID
    public Optional<Subject> getSubjectById(Long subjectId) {
        return subjectRepository.findById(subjectId);
    }

    // Delete Subject
    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
