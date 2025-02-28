package com.psr.springrestsample.sms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psr.springrestsample.sms.model.ContactModel;



@Repository()
public interface ContactRepository extends CrudRepository<ContactModel, Long>{
	ContactModel findById(long id);
}
