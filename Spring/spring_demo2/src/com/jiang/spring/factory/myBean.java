package com.jiang.spring.factory;

import com.jiang.spring.Book;
import com.jiang.spring.Course;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author jiangboss
 * @create 2021-04-22-16:09
 * 工厂bean
 */
public class myBean implements FactoryBean<Course> {
    //
    @Override
    public Course getObject() throws Exception{
        Course course=new Course();
        course.setName("java课程");
        return course;
    }
    @Override
    public Class<?> getObjectType() {
        return null;
    }
    @Override
    public boolean isSingleton() {
        return false;
    }
}
