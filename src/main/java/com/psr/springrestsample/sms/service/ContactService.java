package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.ContactModel;

public interface ContactService {

    ContactModel saveContact(ContactModel contact);

    Iterable<ContactModel> ShowContact();

    ContactModel getContactById(long id);

    void deleteContact(ContactModel contact);
}