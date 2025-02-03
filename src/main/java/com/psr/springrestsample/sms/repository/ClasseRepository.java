package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.psr.springrestsample.sms.model.Classe;


@Component
public interface ClasseRepository extends CrudRepository<Classe, Long>{
    Classe findById(long id);
}