package com.jiang.aop.aopDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author jiangboss
 * @create 2021-04-26-14:39
 */
public class testAop {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aopbean.xml");
        UserDao userDao = context.getBean("userDao", UserDao.class);
          userDao.add(3, 8);
    }
}
