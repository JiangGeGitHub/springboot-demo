package com.example.demo.kafka;

import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by JIANGGE on 2019/6/20.
 */
@Component
public class KafkaTopic {

    public void createTopic() {
        ZkUtils zkUtils = ZkUtils.apply("172.18.183.216:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
        // 创建一个单分区单副本名为t1的topic，第二个参数为分区
        AdminUtils.createTopic(zkUtils, "t2", 2, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);


        zkUtils.close();
    }

    public void delTopic() {
        ZkUtils zkUtils = ZkUtils.apply("172.18.183.216:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
        // 删除topic 't1'
        AdminUtils.deleteTopic(zkUtils, "t1");
        zkUtils.close();
    }


    public void queryTopic() {
        ZkUtils zkUtils = ZkUtils.apply("172.18.183.216:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());

        //获取所有的topic属性
        //zkUtils.getAllTopics();
        // 获取topic 'test'的topic属性属性
        Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), "test");
        // 查询topic-level属性
        Iterator it = props.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        zkUtils.close();
    }

    public void editTopic() {
        ZkUtils zkUtils = ZkUtils.apply("172.18.183.216:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
        Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), "test");
        // 增加topic级别属性
        props.put("min.cleanable.dirty.ratio", "0.3");
        // 删除topic级别属性
        props.remove("max.message.bytes");
        // 修改topic 'test'的属性
        AdminUtils.changeTopicConfig(zkUtils, "test", props);
        zkUtils.close();
    }
}
