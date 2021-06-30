package com.jiang.bean;

/**
 * @author jiangboss
 * @create 2021-04-22-11:03
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }
    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
