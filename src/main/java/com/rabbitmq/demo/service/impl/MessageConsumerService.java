package com.rabbitmq.demo.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("收到消息了：" + new String(message.getBody()));

	}
}
