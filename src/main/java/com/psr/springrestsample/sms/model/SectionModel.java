package com.psr.springrestsample.sms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SectionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sec_id;

	@Column(name = "sec_name")
	private String sec_name;

	public SectionModel(){}

	public void setSecId(long sec_id){
		this.sec_id = sec_id;
	}

	public long getSecId(){
		return sec_id;
	}

	public void setSecName(String sec_name){
		this.sec_name = sec_name;
	}

	public String  getSecName(){
		return sec_name;
	}
}