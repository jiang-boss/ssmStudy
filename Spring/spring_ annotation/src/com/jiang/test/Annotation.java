package com.jiang.test;

import com.jiang.config.SpringConfig;
import com.jiang.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 16:21
 */
public class Annotation {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("abc", UserService.class);
        System.out.println(userService);
        userService.add();
    }
    /**
     * 测试完全注解开发
     */
    @Test
    public  void test2(){
         //这里有所改变  使用 AnnotationConfigApplicationContext实现类加载配置类
        ApplicationContext context =new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService abc = context.getBean("abc", UserService.class);
        System.out.println(abc);
        abc.add();
    }
}
