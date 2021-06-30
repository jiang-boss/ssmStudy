package com.jiang.mybatis;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author jiangboss
 * @create 2021-04-27-9:45
 */
public class Employee implements Serializable {
    private Integer id;
    private String lastname;
    private String emails;
    private String gender;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Employee() {
    }

    public Employee(Integer id, String lastname, String emails, String gender) {
        this.id = id;
        this.lastname = lastname;
        this.emails = emails;
        this.gender = gender;
    }

    public Employee(Integer id, String lastname, String emails, String gender, Dept dept) {
        this.id = id;
        this.lastname = lastname;
        this.emails = emails;
        this.gender = gender;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return emails;
    }

    public void setEmail(String email) {
        this.emails = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", emails='" + emails + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
