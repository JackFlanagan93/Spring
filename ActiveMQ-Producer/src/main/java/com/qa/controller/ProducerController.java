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

	// localhost:61616
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
//		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//        Connection connection = connectionFactory.createConnection();
//        connection.start();
//      //Creating a non transactional session to send/receive JMS message.
//        Session session = connection.createSession(false,
//                Session.AUTO_ACKNOWLEDGE);  
//         
//        //Destination represents here our queue 'JCG_QUEUE' on the JMS server. 
//        //The queue will be created automatically on the server.
//        Destination destination = session.createQueue(subject); 
//         
//        // MessageProducer is used for sending messages to the queue.
//        MessageProducer producer = session.createProducer(destination);
//         
//        // We will send a small text message saying 'Hello World!!!' 
//        Message message = session.createMessage();
//        message.setObjectProperty("Account", account);
//        
//         
		// Here we are sending our message!
		// producer.send(message);
//		AccountEntity accountToSend = new AccountEntity(account);
//		System.out.println(accountToSend.toString());
		// jmsTemplate.convertAndSend("myFirstQueue", account);

//        System.out.println(message);
//        connection.close();
//       return "The following has been added to the Queue: " + message.getObjectProperty("Account");
		sendToQueue(account);
	}

	private void sendToQueue(AccountEntity account) {
		AccountEntity accountToSend = new AccountEntity(account);
		jmsTemplate.convertAndSend("myFirstQueue", accountToSend);
	}

}
