package com.jiang.Test;

import com.jiang.bean.Book;
import com.jiang.bean.Order;
import com.jiang.spring.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangboss
 * @create 2021-04-22-9:26
 */
public class bean1test {
    @Test
    public void  test(){
        //加载spring配置文件  可以用两个接口  BeanFactory    加载配置文件时候不会创建对象
        //                                 ClassPathXmlApplication  加载配置文件的时候就会创建对象  （用这种）
        //    ApplicationContext    里面有两个实现类 FileSystemXmlApplication  和  ClassPathXmlApplication
//         BeanFactory context1= new ClassPathXmlApplicationContext("bean1.xml");


        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("User", User.class);
        System.out.println(user);
        user.add();
    }
    @Test
    public void testbook(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.testBook();
    }

    /**
     * 这里测试使用有参构造的注入
     */
    @Test
    public  void testOrder(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean1.xml");
        Order order = context.getBean("Order", Order.class);
        System.out.println(order);
        order.testorder();
    }

}
