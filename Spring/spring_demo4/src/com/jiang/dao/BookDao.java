package com.jiang.dao;

import com.jiang.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-25-10:27
 */
public interface BookDao {
    void add(Book book);

    void update(Integer integer,Double banlancd);

    void delete(Integer id);

    void findCount();

    Book findBook(Integer integer);

    List<Book> findBooks();

    void batchAddBook(List<Object[]> batch);

    void updateBatch(List<Object[]> batch);

    void deleteBatch(List<Object[]> batch);
}
