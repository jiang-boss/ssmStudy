package com.jiang.Test;

import com.jiang.employeeDao.EmployeeMapper;
import com.jiang.mybatis.Employee;
import com.jiang.mybatis.EmployeeExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
    public void test() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

//    @Test
//    public void test2ISimple() throws IOException {
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        List<Employee> employees = mapper.selectAll();
//        employees.forEach(System.out::println);
//    }
     @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
         SqlSession sqlSession = sqlSessionFactory.openSession();
         EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
         List<Employee> employees = mapper.selectByExample(null);
         EmployeeExample employeeExample=new EmployeeExample();
         //创建一个criteria这里可以实现高级的查询  这里演示模糊查询
         EmployeeExample.Criteria criteria = employeeExample.createCriteria();
         criteria.andLastNameLike("%Bo%");

         EmployeeExample.Criteria criteria1 = employeeExample.createCriteria();
         criteria1.andGenderEqualTo("0");

         employeeExample.or(criteria1);
         //  发的sql语句：select id, last_name, gender, email, d_id from tab_employee WHERE ( last_name like ? )
         List<Employee> employees1 = mapper.selectByExample(employeeExample);
//         employees.forEach(System.out::println);
         System.out.println("**************************************************************");
         employees1.forEach(System.out::println);
     }
}
