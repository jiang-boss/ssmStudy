package com.jiang.test;

import com.jiang.pojo.Book;
import com.jiang.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangboss
 * @create 2021-04-25-10:51
 */
public class jdbcTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        bookService.addBook(new Book(1,3400.00));
        bookService.updateBook(111,78333.00);
    }

    @Test
    public void testupdate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        for (int i=0;i<10;i++){
            bookService.addBook(new Book(i+2,3400.00+i*10));
        }
    }
    @Test
    public void delete(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.delete(111);
    }
    @Test
    //查询某个值
    public void query(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.findCount();
    }
    //根据id查询某个对象
    @Test
    public void query2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = bookService.findBook(3);
        System.out.println(book);
    }
    @Test
    //查询集合
    public void query3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Book> books = bookService.findBooks();
        books.forEach(System.out::println);
    }
    @Test

    //批量添加的测试
    public void testAddBatch(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> o1=new ArrayList<>();
        Object[] objects1={32,2132.00};
        Object[] objects2={33,1313.00};
        Object[] objects3={34,21313.00};
        Object[] objects4={35,2121.00};
        o1.add(objects1);
        o1.add(objects2);
        o1.add(objects3);
        o1.add(objects4);
        bookService.addBatch(o1);
    }

@Test
//批量修改
    public void testUpdateBatch(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> o1=new ArrayList<>();
        //这里的顺序要和sql语句中的参数顺序鸭一致
        Object[] objects1={3278.00,31};
        Object[] objects2={6313.00,32};
        o1.add(objects1);
        o1.add(objects2);
        bookService.updateBatch(o1);
    }
    //批量删除
    @Test
    public void testDeleteBatch(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcbean.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        List<Object[]> o1=new ArrayList<>();
        Object[] objects1={31};
        Object[] objects2={32};
        o1.add(objects1);
        o1.add(objects2);
        bookService.deleteBatch(o1);
    }
}
