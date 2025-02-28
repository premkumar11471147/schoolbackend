package com.psr.springrestsample.sms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="email")
	private String email;

	@Column(name="name")
	private String name;

	@Column(name="message")
	private String message;

	public ContactModel(String email, String message, String name){
		this.email = email;
		this.name = name;
		this.message = message;
	}


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
	 public void setMessage(String message){
	 	this.message = message;
	 }

	 public String getMessage(){
	 	return message;
	 }

	 public void setId(long id){
	 	this.id= id;
	 }

	 public long getId(){
	 	return id;
	 }

}