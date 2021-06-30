package com.jiang.spring;

/**
 * @author jiangboss
 * @create 2021-04-22-14:16
 */
public class Course {
    //课程名称
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
