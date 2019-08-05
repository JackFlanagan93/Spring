package com.qa.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.Account;
import com.qa.repository.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo Repo;
	
	public List<Account> getAllAccounts() {
		List<Account> account = Repo.findAll();
		return account;
		
	}

}
