package com.qa.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
	
	@Bean
	public String printComponent() {
		System.out.println("This is a printed component!");
		return "This is a returned component";
		
	}
	
}
	