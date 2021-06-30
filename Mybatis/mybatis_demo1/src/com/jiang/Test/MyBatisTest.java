package com.jiang.Test;

import com.jiang.employeeDao.EmployeeMapper;
import com.jiang.mybatis.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
/**
 * @author jiangboss
 * 根据配置文件创建一个
 * @create 2021-04-27-10:08
 */
public class MyBatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    /**
     *
     * 两个重要的配置文件
     *       mybatis 的全局配置文件
     *       sql 映射文件
     * 根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     * 有数据源的一些运行环境信息
     * 2.sql映射文件配置了每一个sql 以及sql的封装规则
     * 3.将sql映射文件注册在全局配置文件中
     * 4.写代码
     *      根据全局配置文件得到SQLSessionFactory；
     *      使用sqlSession工厂获取sqlSession对象是用他来进行增删改查
     *      一个sqlSession就是代表和数据库的一次会话 用完关闭
     *      使用sql的唯一标志来告诉mybatis要执行那个sql  sql都是保存在映射文件中
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        //获取SQLSession实例  能直接执行已经映射的sql语句
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第一个参数 sql的唯一标识
        //第二个参数 执行sql的参数
        try {
            Employee selectOne = sqlSession.selectOne("selectEmp", 1);
            System.out.println(selectOne);
        } finally {
            sqlSession.close();
        }
    }
    @Test
    //接口是编程  这个是常用的方式
    //sqlSession对象代表一次会话  用完要关闭
    public void test2() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类对象
            //会为接口自动创建一个代理对象
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee instance = mapper.getInstance(1);//执行者  代理对象
            System.out.println(instance);
        } finally {
            session.close();//用完回话就关闭
        }
    }
}
