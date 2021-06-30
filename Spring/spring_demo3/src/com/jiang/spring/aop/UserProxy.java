package com.jiang.spring.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/**
 * @author jiangboss
 * @create 2021-04-24-20:31
 *如果有多个增强类对同一个方法进行增强可以设置优先级
 */
@Component //创建类
@Aspect//生成代理对象
@Order(value = 3)//设置优先级越小优先级越高
public class UserProxy {
    //让相同的切入点抽取出来  切入点表达式：execution（权限修饰符 返回类型 类的全路径 方法名称【参数列表】）
    @Pointcut(value ="execution(* com.jiang.spring.aop.User.add(..))")
    public void pointdemo(){
    }
    //增加那个增强的功能
    //前置通知  里面要写入切入点表达式
    @Before(value ="pointdemo()")
    public void before(){
        System.out.println("before......");
    }
    //后置通知  这个相当于得出返回值 后执行如果抛出异常就不会执行了
    @AfterReturning(value ="pointdemo()")
    public  void AfterReturn(){
        System.out.println("afterReturn.......");
    }

    //最终通知 相当于finally  都会执行的
    @After(value ="pointdemo()")
    public void after(){
        System.out.println("After..........");
    }
    //异常通知
    @AfterThrowing(value ="pointdemo()")
    public void throwing(){
        System.out.println("throw。。。。。。");
    }
    //环绕通知 这里使用的方法不同 proceedingJoinPoint.proceed()
    @Around(value ="pointdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around之前................");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("around之后..................");
    }
}
