package com.jiang.employeeDao;

import com.jiang.mybatis.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author jiangboss
 * @create 2021-04-27-17:06
 */
public interface EmpAnnotationMapper {
    @Select("select * from tab_employee where id =#{id}")
    public Employee getInstance(Integer id);
}
