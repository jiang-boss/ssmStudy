package com.jiang.mybatis;

import com.jiang.employeeDao.EmployeeMapper;

/**
 * @author jiangboss
 * @create 2021-04-27-9:45
 */
public class Employee{
    private Integer id;
    private String lastname;
    private String emails;
    private String gender;

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
    public String
    toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + emails+ '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
