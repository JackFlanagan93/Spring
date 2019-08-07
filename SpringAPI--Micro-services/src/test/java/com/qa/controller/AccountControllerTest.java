package com.qa.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.entity.Account;
import com.qa.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {

	//Creates an entity of AccountController from com.qa.controller
	@InjectMocks
	AccountController ac;
	
	@Mock
	AccountService as;
	
	@Mock
	Account ae;
	
	private static final Account ACCOUNT1 = new Account((long) 1, "Jack", "Flanagan", "123456789");
	private static final Account ACCOUNT2 = new Account((long) 2, "Robbert", "Goggingson", "234567891");
	private static final Long id = (long) 1231231231;
	
	@Test
	public void getAllAccounts() {
		List<Account> TEST_LIST = new ArrayList<>();
		TEST_LIST.add(ACCOUNT1);
		TEST_LIST.add(ACCOUNT2);
		Mockito.when(as.getAllAccounts()).thenReturn(TEST_LIST);
		assertEquals(TEST_LIST, ac.getAllAccounts());
		Mockito.verify(as).getAllAccounts();
	}
	
	@Test
	public void addAccount() {
		
		Mockito.when(as.addAccount(ACCOUNT1)).thenReturn(ACCOUNT1);
		assertEquals(ACCOUNT1, ac.addAccount(ACCOUNT1));
		Mockito.verify(as).addAccount(ACCOUNT1);
	}
	
	@Test
	public void updateAccount() {
		Mockito.when(as.updateAccount(ACCOUNT1)).thenReturn(ACCOUNT1);
		assertEquals(ACCOUNT1, ac.updateAccount(ACCOUNT1));
		Mockito.verify(as).updateAccount(ACCOUNT1);
	}
	
	@Test
	public void deleteAccount() {
		Mockito.when(as.deleteAccount(id)).thenReturn("Account Deleted");
		assertEquals("Account Deleted", ac.deleteAccount(id));
		Mockito.verify(as).deleteAccount(id);
	}
	
	
	
	
}
