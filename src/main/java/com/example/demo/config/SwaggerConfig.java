package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .apiInfo(apiInfo())
          .select()                                  
          .apis(RequestHandlerSelectors.any())   
          .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
          .paths(PathSelectors.any())                          
          .build()
          .globalOperationParameters(buildParameters());
    }
	
	private List<Parameter> buildParameters() { 
		ParameterBuilder parameterBuilder = new ParameterBuilder();
	    parameterBuilder.name("Authorization")
			    .modelRef(new ModelRef("string"))
			    .parameterType("header")
			    .description("JWT token")
			    .required(false)
			    .build();
	    List<Parameter> parameters = new ArrayList<>();
	    parameters.add(parameterBuilder.build());
	    return parameters;
	}
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	    		"My REST API",
	    	      "Spring Boot description of API end points",
	    	      "1.0",
	    	      "Terms of service",
	    	      new Contact("Priti", "http://localhost:8080/swagger-ui.html", "priti@gmail.com"),
	    	      "License of API","API license URL",Collections.emptyList());
	}
	
	 

	
}
