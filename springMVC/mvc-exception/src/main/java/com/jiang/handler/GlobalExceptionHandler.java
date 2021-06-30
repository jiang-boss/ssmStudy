package com.jiang.handler;

import com.jiang.exception.AgeException;
import com.jiang.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author jiangboss
 * @create 2021-05-16-17:57
 * 注解的意义：控制器增强 给我们的控制器类增强功能 异常处理的功能
 * 特点：必须让框架知道这个注解所在的包名 需要在springmvc配置文件中声明组件扫描 指定所在类的包名
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义方法 处理异常的方法  参数代表的是控制器抛出的异常
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception exception){
//        处理NameException的异常方法  异常发生处理的逻辑
//       异常处理的逻辑
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","姓名不正确");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("nameError");
        return modelAndView;
    }
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception exception){
//        处理NameException的异常方法  异常发生处理的逻辑
//       异常处理的逻辑
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","你的年龄不符合要求");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("ageError");
        return modelAndView;
    }
    /**
     *处理其他的未知异常
     */
    @ExceptionHandler()
    public ModelAndView doOtherException(Exception exception){
//        处理NameException的异常方法  异常发生处理的逻辑
//       异常处理的逻辑
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("msg","哈哈哈");
        modelAndView.addObject("ex",exception);
        modelAndView.setViewName("Other");
        return modelAndView;
    }
}
