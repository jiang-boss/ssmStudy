package com.jiang.dao;

import com.jiang.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
/**
 * @author jiangboss
 * @create 2021-04-25-10:27
 */
@Repository(value = "abc")
public class BookDaoImpl implements BookDao {
    //注入jdbcTemplate  对数据库的操作
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加的操作
     * @param book
     */
    @Override
    public void add(Book book) {
        //对数据操作   添加操作  update有两个参数第一个是sql语句 第二个参数是可变形参   占位符
        String sql="insert into t_act value(?,?)";
        int update = jdbcTemplate.update(sql,book.getActno(), book.getBanlance());
        System.out.println(update);
    }

    /**
     * 修改的操作
     * @param integer
     * @param banlance
     */
    @Override
    public void update(Integer integer,Double banlance) {
        String sql="update t_act set banlance=? where actno=?";
        int update = jdbcTemplate.update(sql,banlance,integer);
        System.out.println(update);
    }
    /**
     * 删除的操作
     * @param id
     */
    @Override
    public void delete(Integer id) {
        String sql="delete from t_act  where actno=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }
    /**
     * 查找多少条的数据
     */
    @Override
    public void findCount() {
     String sql="select count(*) from t_act";
     //第二个参数是返回值对象
     Integer integer = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(integer);
    }
    /**
     * 通过id查找一个对象
     * @param integer
     * @return
     */
    @Override
    public Book findBook(Integer integer) {
        String sql="select * from t_act where actno=?";

        //第二个是一个接口是对一个bean对象的封装  是要返回的是哪种类型个值  这里指的是Book
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), integer);
        return book;
    }
    /**
     * 查找多个对象的集合
     * @return
     */
    @Override
    public List<Book> findBooks() {
        String sql="select * from t_act";
        List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        return query;
    }
    //****************************************************************批量操作*********************************************************/

    /**
     * 批量添加的操作
     * @param batch 添加的集合   里面的Object[]数组对应的是bean中的每个属性的值
     */
    @Override
    public void batchAddBook(List<Object[]> batch) {
        String sql="insert into t_act value(?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batch);
        System.out.println(Arrays.toString(ints));
    }
    /**
     * 批量修改
     * @param batch
     */
    @Override
    public void updateBatch(List<Object[]> batch) {
        String sql="update t_act set banlance=? where actno=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batch);
        System.out.println(Arrays.toString(ints));

    }
    /**
     * 批量删除的操作
     * @param batch
     */
    @Override
    public void deleteBatch(List<Object[]> batch) {
        String sql="delete from t_act  where actno=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batch);
        System.out.println(Arrays.toString(ints));
    }
}
