package com.jiang.pojo;

/**
 * @author jiangboss
 * @create 2021-04-25-10:40
 */
public class Book {
    private Integer actno;
    private Double banlance;
    public Book(){
    }
    public Book(Integer actno, Double banlance) {
        this.actno = actno;
        this.banlance = banlance;
    }

    public Integer getActno() {
        return actno;
    }

    public void setActno(Integer actno) {
        this.actno = actno;
    }

    public Double getBanlance() {
        return banlance;
    }

    public void setBanlance(Double banlance) {
        this.banlance = banlance;
    }

    @Override
    public String toString() {
        return "book{" +
                "actno=" + actno +
                ", banlance=" + banlance +
                '}';
    }
}
