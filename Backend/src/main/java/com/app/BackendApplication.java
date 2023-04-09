package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;
@OpenAPIDefinition(
		info = @Info(title = "REST API",version = "1.1"),
		security = {
				@SecurityRequirement(name = "basicAuth"),
				@SecurityRequirement(name = "bearerToken")
		},
		servers = {
				@Server(url = "/", description = "Default Server URL")
		}
)
@SecuritySchemes({
		@SecurityScheme(name = "basicAuth", type= SecuritySchemeType.HTTP, scheme = "basic"),
		@SecurityScheme(name = "bearerToken", type= SecuritySchemeType.HTTP, scheme = "bearer",bearerFormat = "JWT"),

})
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource ms) {
	LocalValidatorFactoryBean lvfb=new LocalValidatorFactoryBean();
	lvfb.setValidationMessageSource(ms);
	return lvfb;
	}

}
