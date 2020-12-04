package com.smart.rocketmq.listener;

import com.smart.rocketmq.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消费者
 * 实现Listener接口
 * 使用注解
 */
@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "test-group", topic = "hello-topic")
public class TestConsumerListener implements RocketMQListener<String> {

    @Resource
    ConsumerService consumerService;

    @Override
    public void onMessage(String message) {
        log.info(message);
        consumerService.save(message);
    }
}
