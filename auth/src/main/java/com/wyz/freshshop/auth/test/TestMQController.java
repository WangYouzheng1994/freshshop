package com.wyz.freshshop.auth.test;

import com.wyz.freshshop.auth.mq.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/9 12:08
 * @Description:  测试RabbitMQ生产者
 */
@RestController
@RequestMapping("mq")
public class TestMQController {
    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMsg")
    public String sendMsg() {
        return iMessageProvider.send();
    }
}
