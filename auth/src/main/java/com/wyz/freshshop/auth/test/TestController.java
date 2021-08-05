package com.wyz.freshshop.auth.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/7/29 14:18
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/auth/test")
public class TestController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping("getMethod/{id}")
    public String getMethod(@PathVariable String id) {
        return "this is get type method, i've got your request urlparam id : " + id;
    }

    @PostMapping("postMethod")
    public String postMethod(@RequestParam String name) {
        return "this is post type method, i've got your request param name : " + name;
    }

    @PostMapping("timeOutMethod")
    public String timeOutMethod(@RequestBody Map cmuser) {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("timeoutmethod is invoked");
        return "myNameIsTimeOut";
    }

    /**
     * 使用hystrix做服务降级
     * @return
     */
    @PostMapping("degradedService")
    public String degradedService(@RequestPart String lalala) {
        return this.hystrixService.hystrixProvider(lalala);
    }
}
