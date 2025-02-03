package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.Teachers;

public interface TeacherService {

Iterable<Teachers> getAllTeachers();

void saveTeacher(Teachers teacher);

Teachers findById(long id);

void deleteTeacher(Teachers teachers);
    
}
