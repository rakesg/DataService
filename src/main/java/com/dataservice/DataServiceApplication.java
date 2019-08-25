package com.dataservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan({"com"})
public class DataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataServiceApplication.class, args);
	}


	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.paths(PathSelectors.ant("/data/*"))
				.apis(RequestHandlerSelectors.basePackage("com"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails(){
		ApiInfo info = new ApiInfo(
				"Data Service", 
				"Data Service", 
				"1.0",
				"Data Service",
				new Contact("Rakesh Govindaraj", "https://github.com/rakesg/","rakesh.g.thevar@gmail.com"),
				"free","https://github.com/rakesg/", 
				Collections.emptyList());
		return info;
	}
}
