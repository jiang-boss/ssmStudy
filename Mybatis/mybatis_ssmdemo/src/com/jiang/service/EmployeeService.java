package com.jiang.service;

import com.jiang.employeeDao.EmployeeMapper;
import com.jiang.mybatis.Employee;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * @author jiangboss
 * @create 2021-05-06-21:11
 */
@Service
public class EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getEmps(){
        return  employeeMapper.getEmps();
    }


}
