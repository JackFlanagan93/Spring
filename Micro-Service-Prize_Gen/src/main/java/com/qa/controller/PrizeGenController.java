package com.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.PrizeGenService;

@RestController
@RequestMapping("/prize")
public class PrizeGenController{
	
	private PrizeGenService pgs;
	
	@Autowired
	public PrizeGenController(PrizeGenService service) {
		this.pgs = service;
	}
	
	@GetMapping("/generate/{accountNumber}")
	public String prizeGenerator(@PathVariable String accountNumber) {
	return pgs.prizeGenerator(accountNumber);
	}
	
}