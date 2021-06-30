package com.jiang.Test;

import com.jiang.Service.UserService;
import com.jiang.config.txConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangboss
 * @create 2021-04-25-16:31
 */
public class acountTest {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("txbean.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("txbean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    //测试完全注解开发
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(txConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
}
