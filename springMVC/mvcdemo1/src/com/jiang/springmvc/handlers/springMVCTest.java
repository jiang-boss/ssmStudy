package com.jiang.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jiangboss
 * @create 2021-05-13-10:53
 */
@RequestMapping("/springmvc")
@Controller
public class springMVCTest {
    private static final String SUCCESS="success";
    @RequestMapping(value = "/hello3",method = RequestMethod.POST)
    public String testMethod(){
        return SUCCESS;
    }
    @RequestMapping("/hello2")
    public String test(){
        return SUCCESS;
    }
}
