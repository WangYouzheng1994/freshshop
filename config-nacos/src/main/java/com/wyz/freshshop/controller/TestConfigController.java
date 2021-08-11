package com.wyz.freshshop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/10 17:53
 * @Description: 测试是否从nacos获取到了配置
 */
@RestController
@RequestMapping("/nacosConfig")
@RefreshScope
public class TestConfigController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/getConfigInfo")
    public String getConfigInfo() {
        return this.configInfo;
    }
}
