package com.smart.rocketmq.controller;

import com.smart.rocketmq.msg.TestProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestProducerController {

    @Resource
    TestProducerService testProducerService;

    @GetMapping("/send")
    public String sendMsg(String s) {
        testProducerService.sendMsg(s);
        return "我**";
    }
}
