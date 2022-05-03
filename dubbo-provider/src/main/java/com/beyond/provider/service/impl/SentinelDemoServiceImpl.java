package com.beyond.provider.service.impl;

import com.beyond.api.service.SentinelDemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * SentinelDemoServiceImpl
 *
 * @author liujh
 * @date 2022/05/01
 */
@Slf4j
@DubboService(timeout = 20000)
public class SentinelDemoServiceImpl implements SentinelDemoService {

    public static int num1 = 0;

    public static int num2 = 0;

    @Override
    public String useExecutes(String name) {

        int count = num1;

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return name + "对限流接口1的第" + count + "次访问完成";
    }

    @Override
    public String useFuse(String name) {

        int i = 1 / 0;

        return String.valueOf(i);
    }



}
