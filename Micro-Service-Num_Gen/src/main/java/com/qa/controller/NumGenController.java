package com.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.NumGenService;

@RestController
@RequestMapping("/num")
public class NumGenController {
	
	private NumGenService ngs;
	
	@Autowired
	public NumGenController(NumGenService service) {
		this.ngs = service;
	}
	
	@GetMapping("/generate/{digits}")
	public String generateAccountNumber(@PathVariable int digits) {
	return ngs.generateAccountNumber(digits);
	}
			
}
