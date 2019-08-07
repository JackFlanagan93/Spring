package com.qa.controller;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.websocket.server.PathParam;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class ProducerController {

	//localhost:61616
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String subject = "myFirstQueue";
	
	@PostMapping("/run")
	public String sendMessage(@RequestBody Object objectToQueue ) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
      //Creating a non transactional session to send/receive JMS message.
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);  
         
        //Destination represents here our queue 'JCG_QUEUE' on the JMS server. 
        //The queue will be created automatically on the server.
        Destination destination = session.createQueue(subject); 
         
        // MessageProducer is used for sending messages to the queue.
        MessageProducer producer = session.createProducer(destination);
         
        // We will send a small text message saying 'Hello World!!!' 
        Message message = session.createMessage();
        message.setObjectProperty("Account", objectToQueue);
        
         
        // Here we are sending our message!
        producer.send(message);
         
        System.out.println(message);
        connection.close();
       return "Return Statement";
	}
	
}
