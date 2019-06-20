package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @author : GeJiang
 * @description : kafka 消费者组
 * <p>
 * 多个消费者群组可以共同读取同一个主题，彼此之间互不影响。
 * 一个消费者组中的消费者监听指定的分区，并获取消息
 * 如果一个消费者组没有指定要监听的分区，则可以获取全部分区的消息
 */
@Component
@Slf4j
public class KafkaGroupConsumer {

    // 分组1 中的消费者1
    @KafkaListener(id = "consumer1-1", groupId = "group1", topicPartitions =
            {@TopicPartition(topic = Topic.GROUP, partitions = {"0", "1"})
            })
    public void consumer1_1(ConsumerRecord<String, Object> record) {
        System.out.println("consumer1-1 收到消息0,1:" + record.value());
    }

    // 分组1 中的消费者2
    @KafkaListener(id = "consumer1-2", groupId = "group1", topicPartitions =
            {@TopicPartition(topic = Topic.GROUP, partitions = {"2", "3"})
            })
    public void consumer1_2(ConsumerRecord<String, Object> record) {
        System.out.println("consumer1-2 收到消息2,3:" + record.value());
    }

    // 分组1 中的消费者3
    @KafkaListener(id = "consumer1-3", groupId = "group1", topicPartitions =
            {@TopicPartition(topic = Topic.GROUP, partitions = {"0", "1"})
            })
    public void consumer1_3(ConsumerRecord<String, Object> record) {
        System.out.println("consumer1-3 收到消息0,1:" + record.value());
    }

    // 分组2 中的消费者
    @KafkaListener(id = "consumer2-1", groupId = "group2", topics = Topic.GROUP)
    public void consumer2_1(ConsumerRecord<String, Object> record) {
        System.err.println("consumer2-1 收到消息:" + record.value());
    }

    // 分组3 中的消费者
    @KafkaListener(id = "consumer3-1", groupId = "group3", topicPartitions =
            {@TopicPartition(topic = Topic.GROUP, partitions = {"1"})
            })
    public void consumer3_1(ConsumerRecord<String, Object> record) {
        System.out.println("consumer3-1 收到消息1:" + record.value());
    }
}
