package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psr.springrestsample.sms.model.Contact;



@Repository()
public interface ContactRepository extends CrudRepository<Contact, Long>{
	Contact findById(long id);
}
