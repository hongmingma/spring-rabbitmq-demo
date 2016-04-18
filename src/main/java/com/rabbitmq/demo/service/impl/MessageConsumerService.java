package com.rabbitmq.demo.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Service
public class MessageConsumerService implements ChannelAwareMessageListener {

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		// TODO 模拟消费者处理数据的逻辑
		System.out.println("收到消息了：" + new String(message.getBody()));
		Thread.sleep(100);

		// 需要自行处理消息应答，否则会形成消息堆积
		MessageProperties mp = message.getMessageProperties();
		long deliveryTag = mp.getDeliveryTag();
		channel.basicAck(deliveryTag, false);

	}

}
