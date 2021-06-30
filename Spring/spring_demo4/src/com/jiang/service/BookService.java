package com.jiang.service;

import com.jiang.dao.BookDao;
import com.jiang.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-25-10:27
 */
@Service
public class BookService {
    @Autowired//根据类型
    //注入BookDao对象
   @Qualifier(value = "abc")//这个和autowired一起使用
    private BookDao bookDao;
    public void addBook(Book book){
        bookDao.add(book);
    }
    public void updateBook(Integer actno, Double banlace){
        bookDao.update(actno,banlace);
    }
    public void delete(Integer id){
        bookDao.delete  (id);
    }
    //查询操作
    //查询某个值
    public void findCount(){
        bookDao.findCount();
    }
    //查询一个对象
    public Book findBook(Integer id){
        return bookDao.findBook(id);
    }
    //查询多个对象的集合
    public List<Book> findBooks(){
        return bookDao.findBooks();
    }
    //批量添加
    public void addBatch(List<Object[]> batch){
        bookDao.batchAddBook(batch);
    }
    //批量修改
    public void updateBatch(List<Object[]> batch){
        bookDao.updateBatch(batch);
    }
    //批量删除操作
    public void deleteBatch(List<Object[]> batch){
        bookDao.deleteBatch(batch);
    }
}
