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
    @RequestMapping(value = "/user/wode.do",method = RequestMethod.POST)
    public ModelAndView dosome(String name,String age){
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //指定视图 框架对视图进行forword（）操作
//        mv.setViewName("/WEB-INF/view/show.jsp");
        //配置了视图解析器后可以使用逻辑名称指定视图  相当于拼串操作
        mv.setViewName("forward:/show1.jsp");
        return mv;
    }

    /**
     *处理器方法返回ModeAndView 实现重定向
     * 语法：  setView（“redirect：视图完整路径”）
     * redirect ：不和视图解析器一起使用
     *
     * 1。在目标页面中使用参数集合   param.myname来获取值
     *
     * 2.重定向不能访问WEB-INF中受保护的资源
     */
    @RequestMapping(value = "/user/redirect.do",method = RequestMethod.POST)
    public ModelAndView doredirect(String name,String age){
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //指定视图 框架对视图进行forword（）操作
//        mv.setViewName("/WEB-INF/view/show.jsp");
        //配置了视图解析器后可以使用逻辑名称指定视图  相当于拼串操作
//        重定向
        mv.setViewName("redirect:/show2.jsp");
//        http://localhost:8080/mvc_cdx_war_exploded/show2.jsp?myname=lisi&myage=23
        return mv;
    }

}