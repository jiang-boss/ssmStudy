package com.jiang.bean;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 11:11
 */
public class Order {
    private String name;
    private String price;

    public Order(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }


    public void  testorder(){
        System.out.println(name+":"+price);
    }
}
