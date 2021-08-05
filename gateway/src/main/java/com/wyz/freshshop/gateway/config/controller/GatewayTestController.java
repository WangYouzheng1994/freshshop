package com.wyz.freshshop.gateway.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/4 13:12
 * @Description:
 */
@RestController
@RequestMapping("/gateway")
@Slf4j
public class GatewayTestController {
    @RequestMapping("/test")
    public String test() {
        log.info("gateway.test");
        return "gateway.test";
    }
}
