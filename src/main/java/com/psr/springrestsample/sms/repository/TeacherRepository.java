package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psr.springrestsample.sms.model.Teachers;

@Repository
public interface TeacherRepository extends CrudRepository<Teachers, Long> {
    Teachers findById(long id);
}
