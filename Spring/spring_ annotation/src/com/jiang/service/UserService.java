package com.jiang.service;

import com.jiang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 16:19
 */
//默认只可以不写 不写默认值是类的小写字母开头的名称  写了在getBean方法中就要写此时修改的值（abc）
@Service(value = "abc")
public class UserService {

//    @Autowired //根据类型注入
//    @Qualifier(value = "UserDaoImpl")//根据名称注入要和Autowire一起使用因为一个接口可能有多个实现类
//    private UserDao userDao;

   @Resource(name = "UserDaoImpl") //根据名称和类型注入
    private UserDao userDao;
   @Value(value = "姜春雨")
   private String name;
    public void add(){
        System.out.println("userService add........"+name);
        userDao.add();
    }
}
