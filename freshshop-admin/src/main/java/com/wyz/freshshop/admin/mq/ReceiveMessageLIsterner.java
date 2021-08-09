package com.wyz.freshshop.admin.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/9 13:22
 * @Description:
 */
@Slf4j
@EnableBinding(Sink.class)
public class ReceiveMessageLIsterner {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者获取到了信息：{}，端口：{}", message.getPayload(), serverPort);
    }
}
