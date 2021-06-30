package com.jiang.service.inpl;

import com.jiang.dao.StudentDao;
import com.jiang.domain.Student;
import com.jiang.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jiangboss
 * @create 2021-05-15-18:21
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        int i = studentDao.addStudent(student);
        return i;
    }

    @Override
    public List<Student> findStudent() {
        return studentDao.findStudent();
    }
}
