package com.qa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.controller.AccountController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringApiMicroServicesApplicationTests {

	//Creates an entity of AccountController from com.qa.controller
	@Autowired
	private AccountController ac;
	
	@Test
	public void contextLoads() {
		//Verifies that the AccountController created above is not null
		assertThat(ac).isNotNull();
	}

}
