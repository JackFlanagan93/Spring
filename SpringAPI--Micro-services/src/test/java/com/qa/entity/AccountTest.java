package com.qa.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.qa.entity.Account;

public class AccountTest {

	@InjectMocks
	Account ae;
	
	@Mock
	private Account ACCOUNT1;
	private static final Long id = (long) 1;

//	@Test
//	public void getid() {
//		
//		ACCOUNT1.setId(id);
//		Mockito.when(ACCOUNT1.getId()).thenReturn(id);
//		assertEquals(id, ACCOUNT1.getId());
//		Mockito.verify(ae).getId();
//	}
}
