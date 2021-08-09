package com.wyz.freshshop.auth.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/9 11:59
 * @Description:
 */
@Slf4j
@EnableBinding(Source.class)
public class TestMessagejProviderImpl implements IMessageProvider {
    /**
     * 消息管道
     */
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String sendMsg = "通过springStream 给RabbitMQ发送消息";
        output.send(MessageBuilder.withPayload(sendMsg).build());
        log.info("****provider, sendMsg: {}", sendMsg);
        return null;
    }
}
