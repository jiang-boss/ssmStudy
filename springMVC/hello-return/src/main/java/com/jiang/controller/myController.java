package com.jiang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiang.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangboss
 * @create 2021-05-13-14:12
 *能处理请求的是controller控制器称为后端控制器
 * springmvc请求访问的过程
 *    发起some.do请求
 *    Tomcat 把请求发送给中央调度器
 *    dispatcherServlet 根据spring。xml知道some。do-----对应dosome方法
 *    dispatcherServlet把some.do请求给myController处理
 */
@Controller
public class myController {
    /**
     * 返回string逻辑视图名称 配置了视图解析器
     * 也可以不使用视图解析器 此时的return就可以使用完整路径 不要使用return“show”
     *                                                      要使用return"/WEB-INF/view/show.jsp" 这样就可以了
     */
    @RequestMapping(value = "returnString.do",method = RequestMethod.POST)
    public String  returnString(HttpServletRequest request,String name, String age){
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        return "show";
    }
    //ajax请求
    //手工实现ajax请求 代码有重复 java对象转化为json对象
    //httpServletResponse输出json数据
    //这两部分可以交给框架来做  返回值是Object  处理器返回的值也可以是object对象
    @RequestMapping(value = "returnAjax.do",method = RequestMethod.POST)
    public String returnajax(HttpServletResponse response, String name, String age) throws IOException {
        //处理ajax 使用json做数据格式
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        //将对象转换为json对象
        String json="";
        if(student!=null){
            ObjectMapper om=new ObjectMapper();
             json= om.writeValueAsString(student);
            System.out.println("student转换为String"+json);
        }
        //输出数据 响应ajax请求
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
        return "show";
    }
    /**
     * 现在做ajax 主要用json的数据格式 实现步骤：
     * 1.加入依赖  默认jackson
     * 2.在springMvc中加入<mvc:annotation-driven></mvc:annotation-driven>注解驱动
     *              加了这个注解驱动配置  会自动创建消息转换器HttpMessageConverter接口的八个实现类的对象 以供处理不同的返回值类型
     * 3.在处理的方法上加入@ResponseBody注解 响应ajax请求
     * springMVC处理器返回Object 可以转换为json到浏览器响应ajax的内部原理
     * <mvc:annotation-driven>注解驱动
     *    实现的功能是完成java xml text 二进制等数据的转换
     *     HttpMessageConverter接口：消息转换器
     *    功能：定义了java转换为json xml等数据格式的方法 这个接口有很多实现类这些实现类完成java对象到
     *    json java对象到xml  java对象到二进制数据之间的转换
     */
    /**
     *处理器返回一个student 通过框架转换为json  响应ajax请求
     * @ResponseBody注解的作用：
     *        将student转换为json格式的对象 通过httpServletResponse输出给浏览器
     *         1。框架会把返回值student对象 调用框架里面的ArrayList<HttpMessageConverter>中的每个类的canWrite（）方法
     *             检查哪个转换器接口的实现类能处理student类型的数据这时候找到了MappingJackson2HttpServletMessageConverter这个实现类
     *
     *         2.框架会调用实现类的write（）方法把student对象转换为json对象（调用Jackson的objectMapper实现转换）
     *           contentType:application/json;charset=utf-8
     *         3.在方法上面加上@ResponseBody这个注解 来将数据输出到浏览器ajax请求完成.
     */
    @ResponseBody
    @RequestMapping(value = "doStudentAjax.do",method = RequestMethod.POST)
    public Student doStudentAjax( String name, String age) throws IOException {
        //调用service 获取请求结果 Student对象表示结果数据
        Student student =new Student();
        student.setName("jiangboss");
        student.setAge("89");
        return student;//会被框架转换为json
    }
    /**
     * 返回多个对象  一个集合List<student> 一个json数组
     */
    @ResponseBody
    @RequestMapping(value = "doStudentsAjax.do")
    public List<Student> doStudentsAjax(String name, String age) throws IOException {
        //调用service 获取请求结果 Student对象表示结果数据
        List<Student> students=new ArrayList<>();
        Student student=new Student();
        student.setAge("34");
        student.setName("张三");
        students.add(student);

        Student student1=new Student();
        student1.setAge("45");
        student1.setName("李四");
        students.add(student1);
        return students;
    }
    /**
     * 处理器的方法返回的是一个String  返回的是string是一个数据不是一个视图
     *区分返回值是视图还是数据看有没有@ResponseBody这个注解
     *
     */
    @ResponseBody//返回值是数据
    @RequestMapping(value = "doStringData.do",produces = "text/plain;charset=utf-8")//解决中文乱码问题
    public String doStringData(String name,String age){
        return "hello SpringMVC 返回的对象是数据不是视图";
    }

}