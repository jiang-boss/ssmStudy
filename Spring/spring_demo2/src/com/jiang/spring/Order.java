package com.jiang.spring;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 14:29
 */
public class Order {
    private String name;

    public Order() {
        System.out.println("第一步：这个是构造器的方法");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：这个是set方法");
    }
    public void initMethod(){
        System.out.println("第四步：初始化的方法");
    }
    public void  destoryMethod(){
        System.out.println("第七步：销毁的方法");
    }
}
