package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.Course;

public interface CourseService {

    Course saveCourse(Course course);
    void deleteCourse(Course course);
    Course findById(long id);

    Iterable<Course> listAllCourses();
    
}
