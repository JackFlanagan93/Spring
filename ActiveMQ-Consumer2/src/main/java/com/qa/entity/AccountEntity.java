package com.qa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AccountEntity {

	private String firstName;
	private String lastName;
	private String accountNumber;
	private String prize;

	private JsonNode details;

	public AccountEntity(String firstName, String lastName, String accountNumber, String prize) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.prize = prize;
	}

	public AccountEntity(AccountEntity account) {

		this.firstName = account.firstName;
		this.lastName = account.lastName;
		this.accountNumber = account.accountNumber;
		this.prize = account.prize;
	}

	public AccountEntity() {
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
