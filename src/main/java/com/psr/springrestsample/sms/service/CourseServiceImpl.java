package com.psr.springrestsample.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psr.springrestsample.sms.model.CourseModel;
import com.psr.springrestsample.sms.repository.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService  {
    private CourseRepository courseRepositry;

    @Autowired
    public void setCourseRepositry(CourseRepository courseRepository){
        this.courseRepositry = courseRepository;
    }

    @Override
    public Iterable<CourseModel> listAllCourses() {
        return courseRepositry.findAll();
    }

    @Override
    public CourseModel saveCourse(CourseModel course) {
        return courseRepositry.save(course);
    }

    @Override
    public void deleteCourse(CourseModel course) {
        courseRepositry.delete(course);
    }

    @Override
    public CourseModel findById(long id) {
       return  courseRepositry.findById(id);
        
    }
    
}
