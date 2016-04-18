package com.rabbitmq.demo.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author marke
 *
 */
@Service
public class MessageProductorService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void pushToMessageQueue(String routingKey, String message) {
		amqpTemplate.convertAndSend(routingKey, message);
	}

	/**
	 * 
	 * @param destinationQueueName
	 */
	public void popMessage(String destinationQueueName) {
		Message message = amqpTemplate.receive(destinationQueueName);
		if (message != null) {
			System.out.println("主动取出消息成功： " + new String(message.getBody()));
		}

	}

}
