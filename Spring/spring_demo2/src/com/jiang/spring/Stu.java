package com.jiang.spring;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.*;

/**
 * @author jiangboss
 * @create 2021-04-22-13:54
 * 演示注入 数组 list集合 map集合 set集合 list集合元素是对象
 */
public class Stu {

    private String[] courses;
    private List<String> list;
    private Map<String,String> map;
    private Set<String> set;
    private List<Course> courseList;
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void test(){
       System.out.println(Arrays.toString(courses));
       list.forEach(System.out::println);
        System.out.println();
        System.out.println(map);
        System.out.println(set);
        System.out.println(courseList);
   }
}
