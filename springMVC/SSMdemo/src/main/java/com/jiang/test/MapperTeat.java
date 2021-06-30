package com.jiang.test;


import com.jiang.dao.DeptMapper;
import com.jiang.dao.EmployeeMapper;
import com.jiang.domain.Dept;
import com.jiang.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author 22498 jiangBoss
 * @create 2021-06-15
 * @time 16:52
 * 测试类
 * 这里推荐使用spring的单元测试 要导入spring测试的功能模块(spring-test)
 * ContextConfiguration 这个注解指定spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/applicationContext.xml"})
public class MapperTeat {
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    /**
     * 测试部门的mapper
     */
    @Test
    public void testCRUD(){
//        //创建springIOC容器
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        //从容器中获取mapper
//        DeptMapper bean = applicationContext.getBean(DeptMapper.class);
          System.out.println(deptMapper);
          //插入部门
//        Dept dept= new Dept(null, "设计部");
//        int i = deptMapper.insertSelective(dept);
//        System.out.println(i);
        //插入员工
//        int i = employeeMapper.insertSelective(new Employee(null, "zhaoyun", "m", "22548548@qq.com", 1));
//        System.out.println(i);
        //测试批量插入
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i=0;i<1000;i++){
            String uid= UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null, uid, "m", "22548548@qq.com", 1));
        }
        System.out.println("批量插入成功！");
    }
}
