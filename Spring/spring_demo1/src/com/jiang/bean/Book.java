package com.jiang.bean;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 10:57
 */
public class Book {
    private String name;
    private  String author;
    private  String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void  testBook(){
        System.out.println(name+";"+author+";"+address);
    }

}
