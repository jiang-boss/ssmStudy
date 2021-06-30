package com.jiang.employeeDao;

import com.jiang.mybatis.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author jiangboss
 * @create 2021-04-27-12:22
 */
public interface EmployeeMapper {

    //查询多条记录 key为id 值为Employee对象
    @MapKey("id")//指定哪个字段作为查出来map集合中的key   这里是lastname属性作为key
    public Map<Integer,Employee> getEmpByReturnMaps(String name);

    //key是列名  value是列的值
    public Map<String,Object> getEmpByReturnMap(Integer id);
    /**
     * 模糊查询
     * @param lasetname
     * @return
     */
    public List<Employee> getEmpByLike(String lasetname);

    /**
     *  key就是映射文件取出的#（）里面的值
     * @param map
     * @return
     */
    public Employee getEmpByEmp(Map<String, Object> map);

    //增删改查参数
    public Employee getInstance(Integer id);
    public void  insertEmp(Employee employee);
    public void updateEmp(Employee employee);
    public void  deleteEmp(Integer id);
    //多个参数查找 要做特殊的处理 这里给添加的参数添加了一个别名传给sql映射文件时候要取出参数的值得时候要使用这里的别名
    public Employee getEmpByIdAndLastname(@Param("ids") Integer id,@Param("lastnames") String lastname);


}
