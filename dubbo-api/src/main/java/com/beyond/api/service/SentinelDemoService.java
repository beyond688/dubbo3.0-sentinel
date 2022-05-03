package com.beyond.api.service;

/**
 * ExecutesDemoService
 * 限流测试接口
 * @author liujh
 * @date 2022/05/01
 */
public interface SentinelDemoService {

    /**
     * 限流测试接口
     *
     * @param name 名称
     * @return result
     *
     */
    String useExecutes(String name);

    /**
     * 熔断测试接口
     *
     * @param name 名称
     * @return result
     *
     */
    String useFuse(String name);

}
