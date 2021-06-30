package com.jiang.employeeDao;

import com.jiang.mybatis.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author jiangboss
 * @create 2021-04-27-12:22
 */
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
    public List<Employee> getEmps();
}
