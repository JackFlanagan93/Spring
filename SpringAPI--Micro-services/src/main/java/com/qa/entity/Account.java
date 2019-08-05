package com.qa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
		
		@Id
		@GeneratedValue
		private int id;
		private String firstName;
		private String lastName;
		private String accountNumber;
		
		public Account(int id, String firstName, String lastName, String accountNumber) {
			
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.accountNumber = accountNumber;
		}

		public int getId() {
			return id;
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

		public void setId(int id) {
			this.id = id;
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
	
	
	
	
}
