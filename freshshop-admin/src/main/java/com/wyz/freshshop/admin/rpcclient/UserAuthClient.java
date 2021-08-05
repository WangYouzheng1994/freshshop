package com.wyz.freshshop.admin.rpcclient;

import com.wyz.freshshop.admin.auto.entity.CMUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/7/31 17:10
 * @Description: RPC auth
 */
@Component
@FeignClient(value = "CLOUD-AUTH", path = "auth/test")
public interface UserAuthClient {
    /**
     * feign 利用了MVC的注解，从而生成和 Server端需要的参数类型，其Request部分是一定要与Server对应的
     * @param id
     * @return
     */
    @GetMapping("/getMethod/{id}")
    String getMethod(@PathVariable("id") String id);

    @PostMapping("/postMethod")
    String postMethod(@RequestParam("name") String name);

    /**
     * 被调用者响应的时间长，测试feign RPC Timeout
     * @param s
     * @return
     */
    @PostMapping("/timeOutMethod")
    String postTimeOut(@RequestBody CMUser s);

    /**
     * multipart/form-data
     * 因为被请求方 用了 @RequestPart 此注解只能接受  multipart/xxx 因此新增了 headers，produces在这里的设置并没有啥用~~
     * @param lalala
     * @return
     */
    @PostMapping(value = "/degradedService", headers = "content-type=multipart/form-data")
    String degradedService(@RequestPart("lalala") String lalala);
}
