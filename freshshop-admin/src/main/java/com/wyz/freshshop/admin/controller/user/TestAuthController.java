package com.wyz.freshshop.admin.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/10 16:21
 * @Description:
 */
@RestController
@RequestMapping("/testAuth")
public class TestAuthController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public String getAuthPort() {
        return restTemplate.getForObject("http://CLOUD-AUTH/nacos/fromadmin/receive", String.class, "");
    }
}
