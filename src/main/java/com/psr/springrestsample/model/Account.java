package com.psr.springrestsample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Account {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private long id;

private String email;

private String password;

private String role;


    
}
