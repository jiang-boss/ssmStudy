package com.jiang.employeeDao;

import com.jiang.mybatis.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-29-16:25
 */
public interface employeeMapperDySql {
    //测试if 和 trim 标签
    public List<Employee>  getEmpByDyIf(Employee employee);
    public List<Employee>  getEmpByDyTrim(Employee employee);
    //测试choose标签 分支查询
    public List<Employee>  getEmpByDyChoose(Employee employee);
    //员工更新
    public void   updateEmpByDySet(Employee employee);
    //查询多个
    public List<Employee> getEmpByDyForeach(@Param("ids")List<Object> list);

    //批量增加
    public void addEmps(@Param("emps")List<Employee> employeesList);

    //得到共同的的sql
    public List<Employee> getEmpByDyInnerParameter(Employee employee);
}
