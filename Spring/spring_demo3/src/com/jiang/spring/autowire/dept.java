package com.jiang.spring.autowire;

/**
 * @author jiangboss
 * @create 2021-04-25-9:10
 */
public class dept {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
