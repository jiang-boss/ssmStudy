package com.jiang.aop.aopDao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author jiangboss
 * @create 2021-04-26-14:15
 */
@Component//增强的类
public class UserDao {
    public void add(int num1,int num2){
        System.out.println("这是add.....方法是要被增强的方法！");
    }
}
