package com.qa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.Account;
import com.qa.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	private AccountService service;
	
	@Autowired
	public AccountController(AccountService service) {
		this.service = service;
	}
	
	//Find all accounts
	@GetMapping("/getAllAccounts")
	public List<Account> getAllAccounts(){
		return service.getAllAccounts();
	}
	
	
}
