package com.psr.springrestsample.sms.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psr.springrestsample.sms.model.ContactModel;
import com.psr.springrestsample.sms.service.ContactService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@RestController
@RequestMapping("/contact/")
public class ContactController{
    private ContactService contactService;

    @Autowired
    public void setContactService(ContactService contactService){
        this.contactService = contactService;
    }

@GetMapping("show")
public String showContact(Model model, ContactModel contact){
model.addAttribute("contact", contact);
    return "contact";
}

@GetMapping("contactform/send")
public String SendContactForm(@Valid long id, Model model, BindingResult result, ContactModel contact){
    if(result.hasErrors()){
        return "contact";
    }
    contactService.saveContact(contact);
    model.addAttribute("contact", contact);
    return "contact";
}

@GetMapping("contact/delete/{id}")
public String deleteContact(@PathVariable("id") long id, Model model, BindingResult result, ContactModel contact){
    contact = contactService.getContactById(id);
    contactService.deleteContact(contact);
    model.addAttribute("contact", contact);
    return "contact";
}

}