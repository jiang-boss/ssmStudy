package com.jiang.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 14:47
 */
public class MyBeanPost implements BeanPostProcessor {
  @Override
    public  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("第三步：这个是在初始化之前执行的方法");
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步：这个实在初始化之后执行的方法");
        return bean;
    }
}
