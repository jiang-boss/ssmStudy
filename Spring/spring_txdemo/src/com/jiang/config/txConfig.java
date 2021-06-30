package com.jiang.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.sql.DataSource;

/**
 * @author jiangboss
 * @create 2021-04-26-10:25
 * 完全注解开发
 */
@Configuration //代表这是配置类
@ComponentScan(basePackages = "com.jiang")  //开启组件扫描
@EnableTransactionManagement //开启事务的注解
public class txConfig {
    //创建连接数据连接池德鲁伊对象 这里和配置文件中创建是一样的意思
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jiangemp");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        return dataSource;
    }
    @Bean
    //创建jdbcTemplate对象
    public JdbcTemplate getJdbcTemplate(DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //在ioc容器中找到DataSource对象 根据类型去注入 autowire
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    //创建事务管理器
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DruidDataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
