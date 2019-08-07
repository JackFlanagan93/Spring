package com.qa.service;

import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class NumGenService {

	public String generateAccountNumber(int digits) {
		return genString() + genInt(digits);
	}

	public String genInt(Integer option) {

		Random random = new Random();
		String randomNumber = "";

		for (int i = 0; i < option; i++) {
			Integer randomInt = random.nextInt(9);
			randomNumber = randomNumber + randomInt.toString();
		}
		return randomNumber;
	}

	public char genString() {

		Random random = new Random();
		return (char) ('A' + random.nextInt(3));

//		String randomLetter = "";
//		Integer randomNumber = random.nextInt(3);
//
//		if (randomNumber == 0) {
//			randomLetter = "a";
//		} else if (randomNumber == 1) {
//			randomLetter = "b";
//		} else if (randomNumber == 2) {
//			randomLetter = "c";
//		}
//
//		return randomLetter;

	}

}
