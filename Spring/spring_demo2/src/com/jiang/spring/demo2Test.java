package com.jiang.spring;

import com.jiang.spring.factory.myBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.text.resources.cldr.so.FormatData_so;

/**
 * @author jiangboss
 * @create 2021-04-22-14:09
 */
public class demo2Test {
    @Test
    public void test(){
        //加载配置文件
        ClassPathXmlApplicationContext contest = new ClassPathXmlApplicationContext("bean1.xml");
        //得到对象
        Stu stu = contest.getBean("stu", Stu.class);
        stu.test();
    }
    @Test
    public void test2(){
        ClassPathXmlApplicationContext contest = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = contest.getBean("book", Book.class);
        Book book1 = contest.getBean("book", Book.class);
        System.out.println(book);
//        这里说明的是spring创建的bean是单实例对象 两个地址相同
        System.out.println(book1);
        book.printf();
    }
    /**
     * 内置的bean spring中有两种bean
     * 普通的bean：在配置文件中定义的类型就是返回的类型
     * 工厂bean ：在配置文件中定义的bean和返回值的类型不相同
     */
    @Test
    public void test3(){
        ClassPathXmlApplicationContext contest = new ClassPathXmlApplicationContext("bean3.xml");
        Course mybean = contest.getBean("mybean", Course.class);//可以传入不是mybean的类型 myBean实现了FactoryBean接口 泛型
        System.out.println(mybean);
    }

    /**
     * 这里测试bean的生命周期
     */
    @Test
    public  void testBean(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean4.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("第六步：获取的当前bean的实例");
//        System.out.println(order);
        context.close();
    }
}
