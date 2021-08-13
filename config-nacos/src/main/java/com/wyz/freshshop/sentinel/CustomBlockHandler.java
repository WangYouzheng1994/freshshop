package com.wyz.freshshop.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/13 12:45
 * @Description: 设置全局统一的熔断返回处理，配合@SentinelResource(blockHandlerClass= CustomerBlockHandler.class)
 */
public class CustomBlockHandler {
    public static Object handlerException1(BlockException exception) {
        return JSON.toJSON("我是统一的流控规则触发返回1。");
    }

    public static Object handlerException2(BlockException exception) {
        return JSON.toJSON("我是统一的流控规则触发返回2。");
    }
}
