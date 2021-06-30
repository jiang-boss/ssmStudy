package com.jiang.employeeDao;

import com.jiang.mybatis.Employee;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-28-17:20
 */
public interface EmployeeMapperPlus {
    public Employee getEmp(Integer id);
    public Employee getEmpAndDept(Integer id);
    public  Employee getEmpBYIdStep(Integer id);
    //根据 员工d_id查询员工信息
    public List<Employee> getEmpByDeptId(Integer id);
}
