package com.jiang.spring.aop;

import org.springframework.stereotype.Repository;

/**
 * @author jiangboss
 * @create 2021-04-24-20:
 * 被增强的类
 */
@Repository
public class User {

    public void  add(){
        System.out.println(" Useradd........");
    }
}
