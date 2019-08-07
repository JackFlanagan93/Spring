package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.entity.AccountEntity;
import com.qa.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	private AccountService service;
	private RestTemplate restTemplate;
	
	@Autowired
	public AccountController(AccountService service, RestTemplate restTemplate) {
		this.service = service;
		this.restTemplate = restTemplate;
	}
	
	//Find all accounts
	@GetMapping("/getAll")
	public List<AccountEntity> getAllAccounts(){
		return service.getAllAccounts();
	}
	
	//Add Account
	@PostMapping("/add")
	public AccountEntity addAccount(@RequestBody AccountEntity account) {
		
		ResponseEntity<String> accountNumberGen = restTemplate.exchange("http://localhost:8081/num/generate/10", HttpMethod.GET, null, String.class);
		String generatedAccountNumber = accountNumberGen.getBody();
		account.setAccountNumber(generatedAccountNumber);
		
		ResponseEntity<String> prizeGen = restTemplate.exchange("http://localhost:8082/prize/generate/" + accountNumberGen.getBody(), HttpMethod.GET, null, String.class);
		String generatedPrize = prizeGen.getBody();
		account.setPrize(generatedPrize);
		
		return service.addAccount(account);
	}
	
	//Update Account
	@PutMapping("/update")
	public AccountEntity updateAccount(@RequestBody AccountEntity account) {
		return service.updateAccount(account);
	}

	//Delete Account
	@DeleteMapping("/delete/{id}")
	public String deleteAccount(@PathVariable Long id) {
		service.deleteAccount(id);
		return "Account Deleted";

	}
}
