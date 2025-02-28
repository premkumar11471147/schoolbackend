package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psr.springrestsample.sms.model.CourseModel;


@Repository
public interface CourseRepository extends CrudRepository<CourseModel, Long> {
    CourseModel findById(long id);
}