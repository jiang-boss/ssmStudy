package com.jiang.spring.autowire;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangboss
 * @create 2021-04-25-9:10
 */
public class emp {
    private dept de;
    private String name;

    public void setDe(dept dept) {
        this.de = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "emp{" +
                "de=" + de +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     *自动装配的测试
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanwire.xml");
        emp emp = context.getBean("emp", emp.class);
        System.out.println(emp);
    }
}
