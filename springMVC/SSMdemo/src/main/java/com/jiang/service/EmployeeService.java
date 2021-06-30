package com.jiang.service;

import com.jiang.dao.EmployeeMapper;
import com.jiang.domain.Employee;
import com.jiang.domain.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-15
 * @time 19:39
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getALLEmployee() {
       return employeeMapper.selectByExampleWithDept(null);
    }

    public void saveEmployee(Employee employee) {
        employeeMapper.insertSelective(employee);
    }
    /**
     * 检验用户名是否可用
     * @param name
     * @return 返回值代表是否可用  当返回值为true就说明没有查到该条件的 记录数 说明当前的可用
     */
    public boolean checkUser(String name) {
        //创建查询条件
        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpnameEqualTo(name);
        long count = employeeMapper.countByExample(example);
        return count==0;
    }

    /**
     *
     * @param id
     * @return 返回一个对象
     */
    public Employee getemp(Integer id) {
        //根据ID查询员工
        return employeeMapper.selectByPrimaryKey(id);

    }

    public void updateemp(Employee employee) {
        //按照主键有选择的更新
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 根据主键删除员工
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteEmpBatch(List<Integer> ids) {
        EmployeeExample example=new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}
