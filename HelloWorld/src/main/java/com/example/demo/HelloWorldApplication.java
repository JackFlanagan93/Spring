package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {
			
		ApplicationContext ac = SpringApplication.run(AppConfig.class, args);
		

		
		for(int i=0; i<20; i++) {
			System.out.println(i);
			System.out.println(ac.getBean("getTime"));

		}
		
		
		

		System.out.println(ac.getBean("helloWorld"));
		
	
	}
	

}
