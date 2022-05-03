package com.beyond.consumer.controller;

import com.beyond.api.service.SentinelDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;


/**
 * DemoConsumerController
 * 消费者控制层
 * @author liujh
 * @date 2022/05/01
 */
@Slf4j
@RestController
public class DemoConsumerController {

    @Autowired
    private SentinelDemoService sentinelDemoService;

    public static int num1 = 0;

    public static int num2 = 0;

    @RequestMapping("/useExecutes/{name}")
    public String useExecutes(@PathVariable("name") String name) {
        log.info("熔断接口1被访问次数：" + (++num1));

        String result = sentinelDemoService.useExecutes(name);

        log.info("限流接口返回内容：" + result);

        return result;
    }

    @RequestMapping("/useFuse/{name}")
    public String useFuse(@PathVariable("name") String name) {

        log.info("熔断接口1被访问次数：" + (++num2));

        String result = sentinelDemoService.useFuse(name);

        log.info("熔断接口返回内容：" + result);

        return result;
    }

}
