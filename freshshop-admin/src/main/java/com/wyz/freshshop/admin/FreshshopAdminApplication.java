package com.wyz.freshshop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


// @EnableDiscoveryClient  nacos、zookeeper、consul服务发现客户端 springCloud生态中的注解
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker // 开启断路/熔断 cloud common
@SpringBootApplication
public class FreshshopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreshshopAdminApplication.class, args);
    }

}
