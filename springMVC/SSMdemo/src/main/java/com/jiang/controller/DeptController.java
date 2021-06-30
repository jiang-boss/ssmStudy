package com.jiang.controller;

import com.jiang.dao.DeptMapper;
import com.jiang.domain.Dept;
import com.jiang.domain.Msg;
import com.jiang.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-16
 * @time 11:47
 */
@Controller
public class DeptController {
    /**
     * 当弹出模态框就会回显当前的所有部门的信息
     */
    @Autowired
    DeptService deptService;
    @ResponseBody
    @RequestMapping("/dept")
    public Msg getAllDept(){
        List<Dept> depts = deptService.getList();
        System.out.println("部门下拉框的列表ajax请求过来了");
        return Msg.success().add("depts",depts);
    }
}
