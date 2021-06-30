package com.jiang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 17:30
 * 创建配置类  实现完全注解开发
 */
@Configuration //作为配置类代替xml中的注解扫描
@ComponentScan(basePackages = {"com.jiang"})
public class SpringConfig {

}
