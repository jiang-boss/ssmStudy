package com.jiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/user")
public class myController {
    @RequestMapping("some.do")
    public ModelAndView dosome(){
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        mv.addObject("msg","欢迎来到mvc");
        mv.addObject("fun","执行的方法");
        //指定视图 框架对视图进行forword（）操作
//        mv.setViewName("/WEB-INF/view/show.jsp");
        //配置了视图解析器后可以使用逻辑名称指定视图  相当于拼串操作
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping("other.do")
    public ModelAndView othersome(){
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        mv.addObject("msg","欢迎来到mvc other.do方法");
        mv.addObject("fun","执行的方法otherdo");
        //指定视图 框架对视图进行forword（）操作
        mv.setViewName("show");
        return mv;
    }
}