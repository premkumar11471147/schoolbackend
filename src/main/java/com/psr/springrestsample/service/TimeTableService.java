package com.psr.springrestsample.service;


import com.psr.springrestsample.model.ClassModel;
import com.psr.springrestsample.model.SubjectModel;
import com.psr.springrestsample.model.TeacherProfileModel;
import com.psr.springrestsample.model.TimeTableModel;
import com.psr.springrestsample.repository.ClassRepository;
import com.psr.springrestsample.repository.SubjectRepository;
import com.psr.springrestsample.repository.TeacherProfileRepository;
import com.psr.springrestsample.repository.TimeTableRepository;
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
    public TimeTableModel saveTimeTable(TimeTableModel timeTable) {
        // Fetch Teacher, ClassEntity, and Subject from DB
        TeacherProfileModel teacher = teacherProfileRepository.findById(timeTable.getTeacher().getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        ClassModel classEntity = classRepository.findById(timeTable.getClassEntity().getClassId())
                .orElseThrow(() -> new RuntimeException("Class not found"));

        SubjectModel subject = subjectRepository.findById(timeTable.getSubject().getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        // Set the fetched objects
        timeTable.setTeacher(teacher);
        timeTable.setClassEntity(classEntity);
        timeTable.setSubject(subject);

        return timeTableRepository.save(timeTable);
    }


    // Get All Time Tables
    public List<TimeTableModel> getAllTimeTables() {
        return timeTableRepository.findAll();
    }

    // Get Time Table by ID
    public Optional<TimeTableModel> getTimeTableById(Long timeId) {
        return timeTableRepository.findById(timeId);
    }

    // Delete Time Table
    public void deleteTimeTable(Long timeId) {
        timeTableRepository.deleteById(timeId);
    }
}

