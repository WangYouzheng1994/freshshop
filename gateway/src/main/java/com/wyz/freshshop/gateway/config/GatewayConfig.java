package com.wyz.freshshop.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/8/3 22:57
 * @Description:
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // 定义路由方式
        // 如果是包含/guonei的 路由到百度的网站http://news.baidu.com/guonei
        routes.route("path_route_wyz", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();
    }
}
