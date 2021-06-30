package com.jiang.vo;

import org.springframework.stereotype.Controller;

/**
 * @author jiangboss
 * @create 2021-05-13-18:20
 * 保存参数数值的属性
 */

@Controller
public class Student {
    private String name;
    private String age;

    public Student() {
        System.out.println("无参构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
