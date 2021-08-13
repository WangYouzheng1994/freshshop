package com.wyz.freshshop.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.wyz.freshshop.sentinel.CustomBlockHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 测试nacos配置中心
     *
     * @return
     */
    @GetMapping("/getConfigInfo")
    public String getConfigInfo() {
        return this.configInfo;
    }

    /**
     * 测试Sentinel关联限流
     * @return
     */
    @GetMapping("/testA")
    public Object testA() {
        return JSON.toJSON("我是A json，A依赖B");
    }

    /**
     * 测试Sentinel关联限流
     * @return
     */
    @GetMapping("/testB")
    public Object testB() {
        return JSON.toJSON("我是B json， B被A依赖");
    }

    /**
     * 测试Sentinel 热点参数降级
     * 此资源名字叫hotkey，不是testHotkey了哈。
     * 配置的SentinelResource指定了资源的名称，以及限流触发的兜底hotkeyFallback，此兜底不处理运行时异常的抛出。linux 环境变量service
     *
     * @return
     */
    @GetMapping("/testHotkey")
    @SentinelResource(value="hotKey", blockHandler = "hotkeyFallback")
    public Object testHotkey(@RequestParam(required = false) String param1, @RequestParam(required = false) String param2) {
        return JSON.toJSON("我是testHotkey, param1:" + param1+ ", param2:" + param2);
    }

    /**
     * 热点参数 自定义降级回调 参数列表类型需要与原方法匹配，并且新增一个参数 BlockException
     * @return
     */
    public Object hotkeyFallback(String param1, String param2, BlockException b){
        return JSON.toJSON("我是hotkey 降级后的返回值。(*￣︶￣)");
    }


    @GetMapping("/testBlock1")
    @SentinelResource(value="block1", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handlerException1")
    public Object testCustomBlock1() {
        return JSON.toJSON("我是testBlock1，测试流控返回值，(*￣︶￣)");
    }

    @GetMapping("/testBlock2")
    @SentinelResource(value="block2", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handlerException2")
    public Object testCustomBlock2() {
        return JSON.toJSON("我是testBlock2，测试流控返回值，(*￣︶￣)");
    }
}
