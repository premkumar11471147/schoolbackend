package com.psr.springrestsample.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "User API",
        version = "Version 1.0",
        contact = @Contact(
            name = "Premkumar", email = "admin@psr.org", url="https://Premkumar.org"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        ),
        termsOfService = "https://psr.org/",
        description = "Spring Boot Restful API Demo by Prem kumar"
    )
)
public class SwaggerConfig {
    
}
