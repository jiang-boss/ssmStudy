package com.jiang.spring;

import org.junit.Test;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-22-14:31
 */
public class Book {
    private List<String> list;
    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "list=" + list +
                '}';
    }
    public void  printf(){
        System.out.println(list);
    }
}
