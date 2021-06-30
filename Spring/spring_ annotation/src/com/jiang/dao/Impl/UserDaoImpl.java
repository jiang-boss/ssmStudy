package com.jiang.dao.Impl;

import com.jiang.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-10
 * @time 17:04
 */
@Repository(value = "UserDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("userDao的add.......");
    }
}
