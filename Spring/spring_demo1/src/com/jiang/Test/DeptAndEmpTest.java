package com.jiang.Test;

import com.jiang.bean.Emp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jiangboss
 * @create 2021-04-22-11:07
 */
public class DeptAndEmpTest {
    /**
     * 这里是测试嵌套bean 内部bean
     */
    @Test
    public  void test(){
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = co.getBean("emp", Emp.class);
        emp.print();
    }
    /**
     * 外部bean 级联赋值
     */
    @Test
    public  void test2(){
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("bean4.xml");
        Emp emp = con.getBean("emp", Emp.class);
        emp.print();
    }
}
