package com.jiang.domain;


/*
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
*/

import javax.validation.constraints.Pattern;

public class Employee {
    private Integer id;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u4E00-\u9FA5]{2,5})",message ="用户名必须是6到16位字母和数字 或者2到5位汉字")
    private String empname;
    private String gender;
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",message ="你输入的邮箱格式不正确！")
    private String email;

    private Integer dId;
    private  Dept dept;

    public Employee() {
    }
    public Employee(Integer id, String empname, String gender, String email, Integer dId) {
        this.id = id;
        this.empname = empname;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                ", dept=" + dept +
                '}';
    }
}