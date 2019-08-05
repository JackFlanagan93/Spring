package com.example.demo;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	
	@Bean
	public String helloWorld() {

		System.out.println("System Out : Hello World");
		
		return "Returned : Hello World";
	}
	
	@Bean
	@Scope("prototype")
	public LocalTime getTime() {
		
		return LocalTime.now();
		
	}
}
