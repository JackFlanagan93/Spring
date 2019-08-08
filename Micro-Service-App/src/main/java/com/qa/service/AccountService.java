package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.entity.AccountEntity;
import com.qa.repository.AccountRepo;

@Service
public class AccountService {

	@Autowired
	private AccountRepo Repo;

	@Autowired
	private RestTemplate restTemplate;

	// Get All
	public List<AccountEntity> getAllAccounts() {
		List<AccountEntity> account = Repo.findAll();
		return account;
	}

	// Add Account

	public AccountEntity addAccount(AccountEntity account) {

		// list<String>

		HttpEntity<AccountEntity> accountToSend = new HttpEntity<AccountEntity>(account);

		ResponseEntity<String> addAccountToQueue = restTemplate.exchange("http://localhost:8083/a/run", HttpMethod.POST,
				accountToSend, String.class);

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
