package com.qa;

import java.io.IOException;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.AccountEntity;

@Component
public class AccountReciever {

	@Autowired
	private MongoAccountRepo repo;

	@Autowired
	private ObjectMapper objectMapper;

	@JmsListener(destination = "myFirstQueue")
	public void receiveMessage(String account)
			throws JMSException, JsonParseException, JsonMappingException, IOException {

		// ObjectMapper Jackson
		// JSON Util

//		System.out.println("Account ID: " + account.getId() + " Account Number: " + account.getAccountNumber()
//				+ " Account First Name: " + account.getFirstName() + " Account Last Name: " + account.getLastName()
//				+ " Account Prize: " + account.getPrize());

		AccountEntity a = objectMapper.readValue(account, AccountEntity.class);
		repo.insert(a);
	}

//	@JmsListener(destination = "myFirstQueue")
//	public void recieveMessageString(String account) throws JMSException {
//		System.out.println(account);
//	}

}