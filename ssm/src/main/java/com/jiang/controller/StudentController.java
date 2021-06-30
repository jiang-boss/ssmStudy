package com.jiang.controller;

import com.jiang.domain.Student;
import com.jiang.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

/**
 * @author jiangboss
 * @create 2021-05-15-18:24
 */
@RequestMapping("/student")
@Controller
public class StudentController {
    @Resource
    private StudentService studentService;
    //zhucexuesheng
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView modelAndView=new ModelAndView();
        //调用Service
        String tips="注册失败";
        int i = studentService.addStudent(student);
        if (i>0){
            //注册成功
            tips=student.getName()+"注册成功";
        }
        modelAndView.addObject("Tips",tips);
        //指定结果页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
    //处理查询
    @ResponseBody
    @RequestMapping("/listStudent.do")
    public List<Student> queryStudent(){
        //参数检查
        List<Student> student = studentService.findStudent();
        return student;
    }
}
