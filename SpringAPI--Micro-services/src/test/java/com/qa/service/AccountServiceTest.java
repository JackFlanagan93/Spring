package com.qa.service;

import static org.junit.Assert.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.entity.Account;
import com.qa.repository.AccountRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

	@InjectMocks
	AccountService as;
	
	@Mock
	AccountRepo Repo;
	
	private static final Account ACCOUNT1 = new Account((long) 1, "Jack", "Flanagan", "123456789");
	private static final Account ACCOUNT2 = new Account((long) 2, "Robbert", "Goggingson", "234567891");
	
	@Test
	public void getAllAccounts() {
		List<Account> TEST_LIST = new ArrayList<>();
		TEST_LIST.add(ACCOUNT1);
		TEST_LIST.add(ACCOUNT2);
		Mockito.when(Repo.findAll()).thenReturn(TEST_LIST);
		assertEquals(TEST_LIST, as.getAllAccounts());
		Mockito.verify(Repo).findAll();
	}
	
	
	
	
}
