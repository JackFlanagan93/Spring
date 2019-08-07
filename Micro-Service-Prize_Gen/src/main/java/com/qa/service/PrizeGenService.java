package com.qa.service;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class PrizeGenService {

	public String prizeGenerator(String accountNumber) {

		Integer accountNumberLength = accountNumber.length();
		String firstChar;
		firstChar = accountNumber.substring(0, 1);
		String prize = "";

		System.out.println(accountNumberLength);
		System.out.println(firstChar);
		System.out.println(prize);

		
		if (firstChar.equals("A")) {
			
			prize = "Sorry, You Have Not Won A Prize";
		
		} else if (firstChar.equals("B")) {

			switch (accountNumberLength) {

			case 7:
				prize = "You Won! Prize = $50";
				break;
			case 9:
				prize = "You Won! Prize = $500";
				break;
			case 11:
				prize = "You Won! Prize = $5,000";
				break;
			}

		} else if (firstChar.equals("C")) {

			switch (accountNumberLength) {

			case 7:
				prize = "You Won! Prize = $100";
				break;
			case 9:
				prize = "You Won! Prize = $750";
				break;
			case 11:
				prize = "You Won! Prize = $10,000";
				break;

			}

		} 
		
		return "Invalid Account Number, Please Try Again";

		
	}

}

/*
 * 
 * 6 digits and starts with an b you get $50 
 * 8 digits and starts with an b you get $500
 * 10 digits and starts with an b you get $5000
 * 
 * 6 digits and starts with an c you get $100 
 * 8 digits and starts with an c you get $750 
 * 10 digits and starts with an c you get $10000
 * 
 */
