package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.component.MyComponent;

@SpringBootApplication
public class ComponentExampleApplication {

	public static void main(String[] args) {
		
		// Call method directly
		ApplicationContext ac = SpringApplication.run(ComponentExampleApplication.class, args);
		// System.out.println(ac.getBean("printComponent"));
		
		// Make Object
		MyComponent mc = (MyComponent) ac.getBean("myComponent");
		//mc.printComponent();
	    System.out.println(mc.printComponent());
	}

}
