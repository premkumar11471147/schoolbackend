package com.psr.springrestsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.*;


@SpringBootApplication
@SecurityScheme(name = "prem-demo-api", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class SpringrestsampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestsampleApplication.class, args);
	}

}
