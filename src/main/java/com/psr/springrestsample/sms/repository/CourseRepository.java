package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psr.springrestsample.sms.model.Course;


@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findById(long id);
}