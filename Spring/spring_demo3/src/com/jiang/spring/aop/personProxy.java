package com.jiang.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jiangboss
 * @create 2021-04-24-21:00
 */
@Component
@Aspect
@Order(value = 1)
public class personProxy {
    @Before(value ="execution(* com.jiang.spring.aop.User.add(..))" )
    public void before(){
        System.out.println("person before........");
    }
}
