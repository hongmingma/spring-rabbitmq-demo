package com.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rabbitmq.demo.service.impl.MessageConsumerService;
import com.rabbitmq.demo.service.impl.MessageProductorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-rabbitmq-config.xml" })
public class RabbitMQTest {

	@Resource
	private MessageProductorService messageProductorService;
	@Resource
	private MessageConsumerService messageConsumer;

	@Test
	public void testMessageQueue() {
		for (int i = 0; i < 10; i++) {
			messageProductorService.pushToMessageQueue("rabbit_queue_one", "hello world" + i);
			System.out.println("成功插入消息 " + "hello world" + i);
		}
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// while (true) {
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// messageProductorService.popMessage("rabbit_queue_one");
		// }

	}

}
