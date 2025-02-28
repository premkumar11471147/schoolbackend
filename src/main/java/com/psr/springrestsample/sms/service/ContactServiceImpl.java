package com.psr.springrestsample.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psr.springrestsample.sms.model.ContactModel;
import com.psr.springrestsample.sms.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;

    @Autowired
    public void setContactRepository(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactModel saveContact(ContactModel contact) {

        return contactRepository.save(contact);
        
    }

    @Override
    public Iterable<ContactModel> ShowContact() {
        return null;
        
    }

    @Override
    public ContactModel getContactById(long id) {
        
        return contactRepository.findById(id);
    }

    @Override
    public void deleteContact(ContactModel contact) {
        
        contactRepository.delete(contact);
        
    }

}