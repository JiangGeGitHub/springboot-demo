package com.example.demo;

import com.example.demo.kafka.KafkaSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Autowired
	private KafkaSender sender;

	@Test
	public void kafkaTest() {

		for (int i = 0; i < 3; i++) {
			//调用消息发送类中的消息发送方法
			sender.send();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}







