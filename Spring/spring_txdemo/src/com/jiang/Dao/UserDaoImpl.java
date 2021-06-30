package com.jiang.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author jiangboss
 * @create 2021-04-25-16:17
 */
@Repository()
public class UserDaoImpl implements UserDao{
    @Autowired
    //注入对象
    private JdbcTemplate jdbcTemplate;

    /**
     * 少钱的操作
     */
    @Override
    public void reduceMoney() {
        String sql="update t_balance set balance=balance-? where username=?";
        jdbcTemplate.update(sql,100,"li");
    }
    /**
     * 增加的钱的操作
     */
    @Override
    public void addMoney() {
        String sql="update t_balance set balance=balance+? where username=?";
        jdbcTemplate.update(sql,100,"jiang");
    }

}
