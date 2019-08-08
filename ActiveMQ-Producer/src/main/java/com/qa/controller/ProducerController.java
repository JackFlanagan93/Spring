package com.qa.controller;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.entity.AccountEntity;

@RestController
@RequestMapping("/a")
public class ProducerController {

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String subject = "myFirstQueue";

	private RestTemplate template;
	private JmsTemplate jmsTemplate;

	@Autowired
	public ProducerController(RestTemplate template, JmsTemplate jmsTemplate) {

		this.template = template;
		this.jmsTemplate = jmsTemplate;
	}

	@PostMapping(value = "/run", consumes = "application/json")
	public void sendMessage(@RequestBody AccountEntity account) throws JMSException {

		sendToQueue(account);
	}

	private void sendToQueue(AccountEntity account) {
		AccountEntity accountToSend = new AccountEntity(account);
		jmsTemplate.convertAndSend("myFirstQueue", accountToSend);
	}

}
