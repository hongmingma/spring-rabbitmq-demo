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
		for (int i = 0; i < 20; i++) {
			messageProductorService.pushToMessageQueue("rabbit_queue_one", "helloworld" + i);
			System.out.println("成功插入消息 " + "hello world" + i);
		}
		// 一个队列可以并发读，但是每个消息不能并发读到
		// for (int i = 0; i < 200; i++) {
		// new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// messageProductorService.popMessage("rabbit_queue_one");
		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// }).start();
		//
		// }

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
