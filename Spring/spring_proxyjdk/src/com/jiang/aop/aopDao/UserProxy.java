package com.jiang.aop.aopDao;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author jiangboss
 * @create 2021-04-26-14:15
 * aspectj注解的步骤
 *   1.引入相关的依赖jar包
 *   2.在配置文件中映入名称空间context和aop
 *   3.开启注册扫描  在被增强的类和增强类的上方增加注解component
 *   4.再在配置文件中开启aspect 生成代理对象  在代理类上增加aspect注解表示要生成代理对象
 *   5.配置不同类型的通知 在增强类里面  在通知上方增加通知类型的注解使用切入点表达式配置
 */
@Component
@Aspect//表示它要生成代理对象
public class UserProxy {
    @Before(value = "execution(* com.jiang.aop.aopDao.UserDao.add(..))")
    public void before() {
        System.out.println("这是前置通知！");
    }

    @After(value = "execution(* com.jiang.aop.aopDao.UserDao.add(..))")
    public void after() {
        System.out.println("这是后置通知！");
    }

    @AfterThrowing(value = "execution(* com.jiang.aop.aopDao.UserDao.add(..))")
    public void afterThrowing() {
        System.out.println("这是AfterThrowing通知！");
    }

    @AfterReturning(value = "execution(* com.jiang.aop.aopDao.UserDao.add(..))")
    public void returning() {
        System.out.println("这是AfterReturning通知！");
    }

    //环绕通知 比较特殊
    @Around(value = "execution(* com.jiang.aop.aopDao.UserDao.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("这是环绕之前的通知！");
//        被增强的方法的执行
         proceedingJoinPoint.proceed();
        System.out.println("这是环绕之后的通知");
    }
}
