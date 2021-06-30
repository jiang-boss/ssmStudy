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
     *                                                 要使用return"/WEB-INF/view/show.jsp" 这样就可以了
     */
    @RequestMapping(value = "/some.do",method = RequestMethod.POST)
    public ModelAndView returnString(HttpServletRequest request,String name, String age){
        System.out.println("dosome name="+name+"age="+age);
        ModelAndView mv=new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }
}