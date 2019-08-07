package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.qa.entity.AccountEntity;
import com.qa.repository.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo Repo;

	// Get All
	public List<AccountEntity> getAllAccounts() {
		List<AccountEntity> account = Repo.findAll();
		return account;
	}

	// Add Account

	public AccountEntity addAccount(AccountEntity account) {
		 return Repo.save(account);		 
	}

	// Update Account

	public AccountEntity updateAccount(AccountEntity account) {
		AccountEntity accountUpdate = Repo.findById(account.getId()).get();
		accountUpdate.setFirstName(account.getFirstName());
		accountUpdate.setLastName(account.getLastName());
		accountUpdate.setAccountNumber(account.getAccountNumber());
		return Repo.save(accountUpdate);
	}

	// Delete Account

	public String deleteAccount(Long id) {
		 Repo.deleteById(id);
		 return "Account Deleted";
	}

}
