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
    @Test
    //接口是编程  这个是常用的方式
    //sqlSession对象代表一次会话  用完要关闭
    public void test2() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类对象
            //会为接口自动创建一个代理对象
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class); //获得的对象的代理对象
            System.out.println(mapper);
            Employee instance = mapper.getInstance(1);//代理对象执行增删改
            System.out.println(instance);
        } finally {
            session.close();//用完回话就关闭
        }
    }
}
