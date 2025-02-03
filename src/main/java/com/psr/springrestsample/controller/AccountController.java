package com.psr.springrestsample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
public class AccountController {
    
    @GetMapping("/")
    public String demo() {
        return "Hello Spring Rest world";
    }
    

    @GetMapping("/test")
    @Tag(name = "Test", description = "The Test API.")
    @SecurityRequirement(name = "prem-demo-api")
    public String test() {
        return "Test Api";
    }
}
