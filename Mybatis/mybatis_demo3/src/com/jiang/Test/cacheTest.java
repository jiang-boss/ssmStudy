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
 * @create 2021-05-06-14:41
 */
public class cacheTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    /**
     * 测试一级缓存 基于sqlSession级别的缓存
     * 一级缓存失效的情况：sqlSession 不同
     *                    同一个SQLSession相同 但是查询条件不同 两次没有关系  数据不在缓存中
     *                    sqlSession相同但是两次的查询期间进行了增删改操作（可能对当前缓存中的信息有修改 ）
     *                    手动清除了缓存
     * @throws IOException
     *
     *
     */
    @Test
    public void  test1() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee instance = mapper.getInstance(5);
        System.out.println(instance);

        Employee instance1 = mapper.getInstance(5);
        System.out.println(instance1);
        //没有访问两次数据库 第二次是直接从缓存中拿的
    }

    /**
     * 测试二级缓存 基于namespace级别的缓存
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();


        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        Employee instance = mapper.getInstance(5);
        System.out.println(instance);
        sqlSession.close();
        //第二个会话查询  必须会话关闭一级缓存的数据才会到二级缓存中   对应mapper下 这里在EmployeeMapper中
        Employee instance1 = mapper1.getInstance(5);
        System.out.println(instance1);
        sqlSession1.close();
    }
}
