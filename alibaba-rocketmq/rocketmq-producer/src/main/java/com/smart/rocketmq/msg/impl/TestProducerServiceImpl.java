package com.smart.rocketmq.msg.impl;

import com.smart.rocketmq.msg.TestProducerService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 生产者使用
 * RocketMQTemplate 直接使用
 */
@Service
public class TestProducerServiceImpl implements TestProducerService {
    @Value("${msg}")
    String topic;
    /**
     *
     */
    //
    @Resource
    RocketMQTemplate rocketMQTemplate;

    @Override
    public void sendMsg(String s) {
        //使用异步消息
        /**
         * asyncSend(String destination, Message<?> message, SendCallback sendCallback, long timeout,int delayLevel)
         *String destination  目的地（主题）
         *Message<?> message
         *SendCallback sendCallback  回调接口
         *long timeout  发送的超时时间
         * int delayLevel
         * 延迟消息  订单状态   30分钟 取消订单   修改订单状态
         */

        rocketMQTemplate.asyncSend("hello-topic", s, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {

            }

            @Override
            public void onException(Throwable throwable) {

            }
        });
    }
}
