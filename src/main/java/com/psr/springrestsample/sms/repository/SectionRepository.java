package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psr.springrestsample.sms.model.Section;


@Repository
public interface SectionRepository extends CrudRepository<Section, Long>{
    Section findById(long id);
}