package com.jiang.spring.test;

import com.jiang.spring.aop.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangboss
 * @create 2021-04-24-20:39
 */
public class aopTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        User user = classPathXmlApplicationContext.getBean("user", User.class);
        user.add();
    }
}
