package com.jiang.domain;

public class Dept {
    private Integer id;
    private String deptname;

    public Dept() {
    }
    public Dept(Integer id, String deptname) {
        this.id = id;
        this.deptname = deptname;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

}