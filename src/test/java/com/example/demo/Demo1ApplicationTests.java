package com.example.demo;

import com.example.demo.kafka.KafkaProducer;
import com.example.demo.kafka.KafkaProducer;
import com.example.demo.kafka.KafkaTopic;
import com.example.demo.kafka.Topic;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.TopicPartitionReplica;
import org.apache.kafka.common.acl.AclBinding;
import org.apache.kafka.common.acl.AclBindingFilter;
import org.apache.kafka.common.config.ConfigResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

	@Autowired
	private KafkaProducer sender;


	@Autowired
	private KafkaTopic kafkaTopic;

	@Test
	public void kafkaTest() {

		for (int i = 0; i < 3; i++) {
			//调用消息发送类中的消息发送方法
			sender.send(Topic.SIMPLE, "hello spring boot kafka");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void topicTest(){
		kafkaTopic.queryTopic();
	}

}







