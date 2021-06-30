package com.jiang.dao;

import com.jiang.domain.Student;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-05-15-18:10
 */
public interface StudentDao {
    public int addStudent(Student student);
    public List<Student> findStudent();
}
