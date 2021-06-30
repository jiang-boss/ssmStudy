package com.jiang.bean;

/**
 * @author jiangboss
 * @create 2021-04-22-11:03
 */
public class Emp {
    private String name;
    private String age;
    //表示关系
    private Dept dept;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
    public void print(){
        System.out.println("姓名："+name+"性别："+age+"部门"+dept);
    }
}
