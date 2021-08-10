package com.wyz.freshshop.auth.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/10 16:07
 * @Description:
 */
@RestController
@RequestMapping("/nacos/fromadmin")
public class TestNacosRibbonController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/receive")
    public String getAdmin() {
        return "我的端口是：" + serverPort;
    }
}
