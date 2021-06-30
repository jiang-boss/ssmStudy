package com.jiang.controller;

import com.jiang.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
    //逐个获取参数 这里post请求会有乱码问题 可以使用过滤器处理乱码的问题
    @RequestMapping(value = "wode.do",method = RequestMethod.POST)
    public ModelAndView dosome(String name,String age){
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //指定视图 框架对视图进行forword（）操作
//        mv.setViewName("/WEB-INF/view/show.jsp");
        //配置了视图解析器后可以使用逻辑名称指定视图  相当于拼串操作
        mv.setViewName("show");
        return mv;
    }

    /**
     * 请求的参数名和处理器的形参的名称不相同 用注解来解决
     * required来表示请求的参数必须有
     */
    @RequestMapping(value = "getparam.do",method = RequestMethod.POST)
    public ModelAndView getparam(@RequestParam(value = "rname",required = false) String name,
                                 @RequestParam(value = "rage",required = false) String age){
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //指定视图 框架对视图进行forword（）操作
//        mv.setViewName("/WEB-INF/view/show.jsp");
        //配置了视图解析器后可以使用逻辑名称指定视图  相当于拼串操作
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value = "getObject.do",method = RequestMethod.POST)
    public ModelAndView getObject(Student student){
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        mv.addObject("myname",student.getName());
        mv.addObject("myage",student.getAge());
        mv.addObject("mystudent",student);
        //指定视图 框架对视图进行forword（）操作
//        mv.setViewName("/WEB-INF/view/show.jsp");
        //配置了视图解析器后可以使用逻辑名称指定视图  相当于拼串操作
        mv.setViewName("show");
        return mv;
    }
}