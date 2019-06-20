package com.example.demo.web;

import com.alibaba.fastjson.JSON;
import com.example.demo.kafka.KafkaProducer;
import com.example.demo.kafka.Topic;
import com.example.demo.pojo.City;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : GeJiang
 * @description :  测试消息发送
 */

@RestController
@RequestMapping("/kafka/")
public class KafkaSendMsgController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /***
     * 发送消息体为基本类型的消息
     */

    @GetMapping("sendSimple")
    public void sendSimple() {
        producer.send(Topic.SIMPLE, "hello spring boot kafka");
    }

    /***
     * 发送消息体为bean的消息
     */
    @GetMapping("sendBean")
    public void sendBean() {
        City programmer = new City( 1, "北京");
        producer.send(Topic.BEAN, JSON.toJSON(programmer).toString());
    }


    /***
     * 多消费者组、组中多消费者对同一主题的消费情况
     */
    @GetMapping("sendGroup")
    public void sendGroup() {
        for (int i = 0; i < 4; i++) {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(Topic.GROUP, i % 4, "key", "hello group " + i);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.error("发送消息失败:" + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Object> sendResult) {
                    log.info("发送结果:" + sendResult.toString());
                }
            });
        }
    }
}
