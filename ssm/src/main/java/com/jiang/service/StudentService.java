package com.jiang.service;

import com.jiang.domain.Student;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-05-15-18:19
 */
public interface StudentService {
    public int addStudent(Student  student);
    public List<Student> findStudent();
}
