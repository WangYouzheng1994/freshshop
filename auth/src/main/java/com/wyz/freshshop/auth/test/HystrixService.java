package com.wyz.freshshop.auth.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/1 21:40
 * @Description: 测试熔断器
 */
@Slf4j
@Service
public class HystrixService {

    /**
     * 设置降级方法，如果3000ms没执行完，走降级方法
     *
     * @param params
     * @return
     */
    @HystrixCommand(fallbackMethod = "longTimeFallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String hystrixProvider(String params) {
        // 服务提供者自身内部的 服务降级代码，便于快速响应
        log.info("开始猛睡");
        int i = 0;
        while (i < 2000000) {
            i++;
            // Thread.sleep(50L);
            log.info("猛输出~ {}", i);
        }
        return "i am a normal method";
    }

    /**
     * 保证形参相同，估计是用的代理，如果达到阈值了，重新调这个方法然后return
     *
     * @return
     */
    protected String longTimeFallBack(String params) {
        log.warn("进入熔断【longTimeFallBack】");
        return "i am running please wait a minute, thank u (*￣︶￣)";
    }
}
