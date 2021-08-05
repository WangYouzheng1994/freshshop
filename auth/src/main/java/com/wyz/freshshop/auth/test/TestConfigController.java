package com.wyz.freshshop.auth.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/5 16:36
 * @Description:
 */
@RefreshScope
@RestController
@RequestMapping("/requestMapping")
public class TestConfigController {
    @Value("${config.info}")
    private String config;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return config;
    }
}
