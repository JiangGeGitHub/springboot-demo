package com.example.demo.config.kafka;


import com.example.demo.kafka.Topic;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : GeJiang
 * @description : kafka配置类
 */
@Configuration
public class KafkaConfig {

    /*
    在启动阶段初始化一个topic,分区数量，和复制因子
     */
    @Bean
    public NewTopic groupTopic() {
        // 指定主题名称，分区数量，和复制因子
        return new NewTopic(Topic.GROUP, 10, (short) 2);
    }

}
