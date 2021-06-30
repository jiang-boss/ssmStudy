package com.jiang.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangboss
 * @create 2021-05-13-10:14
 */
@Controller
public class HelloWorld {
    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
}
