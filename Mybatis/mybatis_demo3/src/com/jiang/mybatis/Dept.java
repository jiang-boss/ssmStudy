package com.jiang.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-28-18:28
 */
public class Dept implements Serializable {
    private Integer id;
    private  String deptName;
    private List<Employee> employees;

    public Dept() {
    }

    public Dept(Integer id) {
        this.id = id;
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
