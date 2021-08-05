package com.wyz.freshshop.admin.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/1 20:10
 * @Description:
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
       return Logger.Level.FULL;
    }
}
