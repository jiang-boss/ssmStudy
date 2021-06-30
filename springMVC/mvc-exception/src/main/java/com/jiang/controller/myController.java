package com.jiang.controller;

import com.jiang.exception.*;
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
    //逐个获取参数 这里post请求会有乱码问题 可以使用过滤器处理乱码的问题 在webxml中配置了
    @RequestMapping(value = "/user/wode.do",method = RequestMethod.POST)
    public ModelAndView dosome(String name,Integer age) throws MyUserException {
        ModelAndView mv=new ModelAndView();
        //添加数据 框架把最后请求的数据添加到request域中
        //根据请求的参数抛出异常
        if(!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }
        if (!"20".equals(age)){
            throw new AgeException("年龄不正确");
        }
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //指定视图 框架对视图进行forword（）操作
//        mv.setViewName("/WEB-INF/view/show.jsp");
        //配置了视图解析器后可以使用逻辑名称指定视图  相当于拼串操作
        mv.setViewName("show");
        return mv;
    }
}