package com.jiang.controller;

import com.jiang.mybatis.Employee;
import com.jiang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jiangboss
 * @create 2021-05-06-21:06
 */
@Controller
public class EmpController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getemps")
    public String Emps(Map<String,Object> map){
        List<Employee> emps =employeeService.getEmps();
        map.put("allemps",emps);
        return "list";
    }
}
