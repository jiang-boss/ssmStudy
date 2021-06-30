package com.jiang.employeeDao;

import com.jiang.mybatis.Employee;

/**
 * @author jiangboss
 * @create 2021-04-27-12:22
 */
public interface EmployeeMapper {
    public Employee getInstance(Integer id);
}
