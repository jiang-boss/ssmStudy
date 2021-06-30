package com.jiang.employeeDao;

import com.jiang.mybatis.Dept;
import com.jiang.mybatis.Employee;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-28-21:28
 */
public interface deptMapper {


    public Dept getDept(Integer id);

    //两张表一起查
    public  Dept getDeptById(Integer id);
    //分步查询
    public Dept getDeptByIdStep(Integer id);
}
