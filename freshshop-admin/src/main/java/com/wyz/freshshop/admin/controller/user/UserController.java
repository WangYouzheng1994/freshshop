package com.wyz.freshshop.admin.controller.user;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wyz.freshshop.admin.auto.entity.CMUser;
import com.wyz.freshshop.admin.rpcclient.UserAuthClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/6/7 20:56
 * @Description: 用户服务
 */
@Slf4j
@RestController
@RequestMapping("test")
@DefaultProperties(defaultFallback = "userControllerGlobleFallBack")
public class UserController {
    @Autowired
    private UserAuthClient userAuthClient;

    @GetMapping("getFeign")
    public String testGetFeign() {
        return this.userAuthClient.getMethod("wyzId");
        // return "";
    }

    @PostMapping("postFeign")
    public String testPostFeign() {
        return this.userAuthClient.postMethod("wyzNasme");
    }

    @PostMapping("testTimeOut/{id}")
    public String testTimeOut(@PathVariable("id") String id, @RequestHeader("headerParam") String headerP, @RequestParam String userName) {
        log.info("id:{}, header:{}, param:{}, body:{}", id, headerP, userName);
        CMUser user = new CMUser();
        user.setAge(123).setAddress("你好");
        log.info("start feign rpc");
        return this.userAuthClient.postTimeOut(user);
    }

    @GetMapping("degraded")
    public String degradedService() {
        log.info("userController.degraded invoke Start");
        String resultStr = this.userAuthClient.degradedService("params wyzwyz123123");
        log.info("userController.degraded invoke result is ：{}", resultStr);
        return resultStr;
    }

    /**
     * 两秒不响应 就要进longTimeFallBack的降级兜底方法
     * @return
     */
    // @HystrixCommand(fallbackMethod = "longTimeFallBack", commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1000")})
    @HystrixCommand(commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1000")})
    @GetMapping("invokerDegraded")
    public String invokerDegraded() {
        log.info("userController.invokerDegraded invoke Start");
        String resultStr = this.userAuthClient.degradedService("params wyzwyz123123");
        log.info("userController.invokerDegraded invoke result is ：{}", resultStr);
        return resultStr;
    }

    public String longTimeFallBack() {
        log.warn("controller invoker is enter longTimeFallBack method");
        return "i am invoker hystrix fallback 【longTimeFallBack】 (*￣︶￣)";
    }

    public String userControllerGlobleFallBack() {
        log.warn("进去 userController全局fallback");
        return "我是userController的全局服务降级fallback方法";
    }
}
