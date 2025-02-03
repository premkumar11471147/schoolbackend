package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.Contact;

public interface ContactService {

    Contact saveContact(Contact contact);

    Iterable<Contact> ShowContact();

    Contact getContactById(long id);

    void deleteContact(Contact contact);
}