package com.qa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class AccountEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String firstName;
		private String lastName;
		private String accountNumber;
		private String prize;
		
		public AccountEntity(Long id, String firstName, String lastName, String accountNumber, String prize) {
			
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.accountNumber = accountNumber;
		}
		
		public AccountEntity() {}

		public Long getId() {
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

		public String getPrize() {
			return prize;
		}

		public void setId(Long id) {
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

		public void setPrize(String prize) {
			this.prize = prize;
		}
		
		
	
	
	
	
}
