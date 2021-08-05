package com.wyz.freshshop.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author WangYouzheng
 * @version 1.0
 * @since: 2021/6/7 20:57
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.wyz.freshshop.admin.auto.mapper"}) // Mapper接口扫描, "com.wyz.freshshop.admin.auto.entity"
public class MybatisConfig {
}
