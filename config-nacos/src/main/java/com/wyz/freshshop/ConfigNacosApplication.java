package com.wyz.freshshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 服务发现
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosApplication.class, args);
    }

}
