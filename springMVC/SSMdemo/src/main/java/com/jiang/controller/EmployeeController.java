package com.jiang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiang.domain.Employee;
import com.jiang.domain.Msg;
import com.jiang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-15
 * @time 19:33
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    /**
     * 查询员工查询（不使用）
     * @return
     */
    @RequestMapping("/emp")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //在查询之前需要调用 传入页码 和每页的大小
        //这个查询就是分页查询
        PageHelper.startPage(pn,5);
        List<Employee> employeeList=employeeService.getALLEmployee();
        //使用这个包装查询到的结果 将pageInfo交给页面  这里面封装了详细的数据  5是连续显示页码的条数
        PageInfo page=new PageInfo(employeeList,5);
        model.addAttribute("pageInfo",page);
        return "list";
    }
    /**
     * ajax获取主页的数据
     * @param pn
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/jsonemps")
    public Msg getEmpWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //在查询之前需要调用 传入页码 和每页的大小
        //这个查询就是分页查询
        PageHelper.startPage(pn,5);
        List<Employee> employeeList=employeeService.getALLEmployee();
        //使用这个包装查询到的结果 将pageInfo交给页面  这里面封装了详细的数据  5是连续显示页码的条数
        PageInfo page=new PageInfo(employeeList,6);
//        model.addAttribute("pageInfo",page);
        //这里实现链式操作
        return  Msg.success().add("pageinfo",page);
    }
    /**
     * @param employee
     * @param result 封装校验的结果
     * @return
     * @Valid  代表需要进行校验的对象 这里使用JSR303实现后端的校验
     */
    @ResponseBody
    @RequestMapping( "/empSave")
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
        System.out.println(result.hasErrors());//打印错误信息
        if(result.hasErrors()){
            //检验失败 在模态框中显示校验失败的信息
            Map<String,Object> map=new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError:fieldErrors){
                //将错误的字段名和错误的信息封装在一个map中
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            //提交给浏览器显示
            return Msg.faild().add("errormsg",map);
        }else {
            employeeService.saveEmployee(employee);
            System.out.println("添加员工信息成功！");
            return Msg.success();
        }
    }
    /**
     * 处理判断用户名是否可用的ajax请求
     * @param empName
     * @return
     */
    @ResponseBody
    @RequestMapping("/exitName")
    public Msg exitNameAjax( String empName){
        System.out.println("判断员工的名称是否合法请求过来了");
        //判断得到的名称的格式是否合法
        String rgx="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u4E00-\u9FA5]{2,5})";
        //判断是否合法
        if (!empName.matches(rgx)) {
            return Msg.faild().add("ajax_err","用户名必须是6到16位字母和数字 或者2到5位汉字");
        }
        //这里判断是否重复
        boolean flag=employeeService.checkUser(empName);
        if(flag){
            //可用返回true   可以根据状态码判断是可用
            return Msg.success();
        }else {
            //不可用返回 false
            return Msg.faild().add("ajax_err","用户名不可用！");
        }
    }
    /**
     *根据id查询员工
     * @param id
     * @return
     * PathVariablev 这个注解指的是从请求的路径中找到id这个参数
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id){
        System.out.println("查找员工的请求");
        Employee employee= employeeService.getemp(id);
        return Msg.success().add("emp",employee);
    }
    /**
     * 保存修改的信息
     * @param employee
     * @return
     * 要是jQuery直接发送putajax请求就会出现错误所有的 参数的信息都为空
     * 要更新的数据：Employee{id=1, empname='null', gender='null', email='null', dId=null, dept=null}
     * 问题：请求体中有信息 但是封装的employee没有信息
     * 原因 tomcat的问题:
     * tomcat将请求体中的信息封装成一个map
     * 然后springMVC封装pojo的时候会把pojo中每个属性的值  都 request.getParamter()
     * ajax发送put请求不能直接发  发了 就不会封装成map所以就娶不到各个参数的值
     *     处理方法：配置FormContentFilter过滤器 这样put请求就会将请求过来的数据封装成map
     *      将request重新包装
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg  updateEmp( Employee employee){
        System.out.println("要更新的数据："+employee);
        employeeService.updateemp(employee);
        return Msg.success();
    }
    /**
     * 这里处理删除的操作
     * 这里改成单个批量删除统一方法
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delEmp/{ids}",method = RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable String ids){
        if(ids.contains("-")){
            //批量删除
            List<Integer> list=new ArrayList<>();
            String[] split = ids.split("-");
            for (String id:split){
                //这里遍历出每一个id
                int i = Integer.parseInt(id);
                list.add(i);
            }
            employeeService.deleteEmpBatch(list);
        }else {
            //单个删除
            int i = Integer.parseInt(ids);
            employeeService.deleteEmp(i);
        }
        return Msg.success();
    }
}
