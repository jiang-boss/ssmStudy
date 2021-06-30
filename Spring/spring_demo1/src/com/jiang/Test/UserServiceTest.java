package com.jiang.Test;

import com.jiang.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangboss
 * @create 2021-04-22-10:48
 */
public class UserServiceTest {
    /**
     * 这里测试外部bean的注入
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = co.getBean("userService", UserService.class);
        userService.updateTest();
    }
}
