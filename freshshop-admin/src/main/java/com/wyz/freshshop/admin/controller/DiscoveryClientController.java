package com.wyz.freshshop.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/7/29 21:08
 * @Description:
 */
@RestController
@RequestMapping("dcc")
@Slf4j
public class DiscoveryClientController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/discover")
    public Object discover() {
        // 获取服务清单 springApplicationName
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("****element: {}", service);
        }
        // 获取指定StringApplication的所有信息
        List<ServiceInstance> instances = discoveryClient.getInstances("fresh-admin");
        instances.parallelStream().forEach(i -> {
            log.info("instantceid:{}, serviceid:{}, host:{}, port:{}, uri:{}", i.getInstanceId(), i.getServiceId(), i.getHost(), i.getPort(), i.getUri());
        });
        return discoveryClient;
    }
}
