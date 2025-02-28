package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psr.springrestsample.sms.model.SectionModel;


@Repository
public interface SectionRepository extends CrudRepository<SectionModel, Long>{
    SectionModel findById(long id);
}