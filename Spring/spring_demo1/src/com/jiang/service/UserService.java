package com.jiang.service;

import com.jiang.Dao.UserDao;
import com.jiang.Dao.impl.UserDaoImpl;

/**
 * @author jiangboss
 * @create 2021-04-22-10:40
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void  updateTest(){
        System.out.println("service的updateTest方法");
        //普通实现原始方式
//        UserDao userDao=new UserDaoImpl();
//        userDao.update();
        userDao.update();
    }
}
