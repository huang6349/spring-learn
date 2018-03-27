package org.hyl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaAuditing // 开启数据审计
@EnableTransactionManagement // 开启事务管理
public class DatabaseConfiguration {
}
