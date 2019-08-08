package com.qa;

import javax.jms.Connection;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ActiveMqConsumerApplication {

	   // URL of the JMS server
    
	
	public static void main(String[] args) throws JMSException {
		
		
		
		SpringApplication.run(ActiveMqConsumerApplication.class, args);
		
		 // Getting JMS connection from the server
        
    }
		 
	}


