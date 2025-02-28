package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.CourseModel;

public interface CourseService {

    CourseModel saveCourse(CourseModel course);
    void deleteCourse(CourseModel course);
    CourseModel findById(long id);

    Iterable<CourseModel> listAllCourses();
    
}
