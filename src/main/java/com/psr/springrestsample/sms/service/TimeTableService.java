package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.*;
import com.psr.springrestsample.sms.repository.ClassRepository;
import com.psr.springrestsample.sms.repository.SubjectRepository;
import com.psr.springrestsample.sms.repository.TeacherProfileRepository;
import com.psr.springrestsample.sms.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TimeTableService {
    @Autowired
    private TeacherProfileRepository teacherProfileRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TimeTableRepository timeTableRepository;

    // Add or Update Time Table
    public TimeTable saveTimeTable(TimeTable timeTable) {
        // Fetch Teacher, ClassEntity, and Subject from DB
        TeacherProfile teacher = teacherProfileRepository.findById(timeTable.getTeacher().getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        ClassEntity classEntity = classRepository.findById(timeTable.getClassEntity().getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found"));

        Subject subject = subjectRepository.findById(timeTable.getSubject().getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        // Set the fetched objects
        timeTable.setTeacher(teacher);
        timeTable.setClassEntity(classEntity);
        timeTable.setSubject(subject);

        return timeTableRepository.save(timeTable);
    }


    // Get All Time Tables
    public List<TimeTable> getAllTimeTables() {
        return timeTableRepository.findAll();
    }

    // Get Time Table by ID
    public Optional<TimeTable> getTimeTableById(Long timeId) {
        return timeTableRepository.findById(timeId);
    }

    // Delete Time Table
    public void deleteTimeTable(Long timeId) {
        timeTableRepository.deleteById(timeId);
    }
}

