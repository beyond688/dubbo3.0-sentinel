package com.beyond.consumer.config;

import com.beyond.api.service.SentinelDemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ReferenceConfiguration
 * dubbo中的bean配置类
 *
 * @author liujh
 * @date 2022/05/01
 */
@Configuration
public class ReferenceConfiguration {
    // 依托于Spring容器的好处在于职责的划分更加清晰，dubbo本身只负责于rpc的通信，而bean的管理交还给spring，
    // 而且使ReferenceAnnotationBeanPostProcessor类更加轻，dubbo的关注点更加集中。

    @Bean
    @DubboReference(check = false)
    public ReferenceBean<SentinelDemoService> sentinelDemoService() {
        return new ReferenceBean();
    }

}
