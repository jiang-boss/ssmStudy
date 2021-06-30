package com.jiang.Test;

import com.jiang.employeeDao.*;
import com.jiang.mybatis.Dept;
import com.jiang.mybatis.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
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
     * 两个重要的配置文件
     * mybatis 的全局配置文件
     * sql 映射文件
     * 根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     * 有数据源的一些运行环境信息
     * 2.sql映射文件配置了每一个sql 以及sql的封装规则
     * 3.将sql映射文件注册在全局配置文件中
     * 4.写代码
     * 根据全局配置文件得到SQLSessionFactory；
     * 使用sqlSession工厂获取sqlSession对象是用他来进行增删改查
     * 一个sqlSession就是代表和数据库的一次会话 用完关闭
     * 使用sql的唯一标志来告诉mybatis要执行那个sql  sql都是保存在映射文件中
     *
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
            Employee selectOne = sqlSession.selectOne("com.jiang.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(selectOne);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void annotationTest() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类对象
            //会为接口创建一个代理对象
            EmpAnnotationMapper mapper = session.getMapper(EmpAnnotationMapper.class);
            Employee instance = mapper.getInstance(1);
            System.out.println(instance);
        } finally {
            session.close();
        }
    }

    /**
     * 测试增删改的操作
     * @throws Exception
     */
    @Test
    public void test3() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成该接口的实现类的代理对象
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //mybatis 允许我们增删改可以有以下类型的返回值 Boolean  Long Integer   手动提交数据（注意点）
//        sqlSessionFactory.openSession()------》手动提交  在openSession中加入参数TRUE就是自动提交
            //测试添加
//        Employee employee=new Employee(null,"jiangboss","2329832@qq.com","1");
//        mapper.insertEmp(employee);
//        sqlSession.commit();
//        System.out.println(employee);
            //测试修改
//        mapper.updateEmp(new Employee(5,"jiang","2249846316@qq.com","男"));
//        sqlSession.commit();
            //测试删除
        mapper.deleteEmp(18);
        sqlSession.commit(); //进行增删改要手动提交数据
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 这里是测试多个参数处理的测试
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //生成该接口的实现类的代理对象
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //mybatis 允许我们增删改可以有以下类型的返回值 Boolean  Long Integer   手动提交数据（注意点）
//        sqlSessionFactory.openSession()------》手动提交  在openSession中加入参数TRUE就是自动提交
//            多个参数mybatis做出来特殊处理
            Employee jiang = mapper.getEmpByIdAndLastname(7, "jiangboss");
            //参数是map的时候
//            Map<String,Object> map=new HashMap<>();
//            map.put("id1",5);
//            map.put("lastname1","jiang");
//            Employee empByEmp = mapper.getEmpByEmp(map);
            sqlSession.commit();
//            System.out.println(empByEmp);
            System.out.println(jiang);
        } finally {
            sqlSession.close();
        }
    }

    /**
     *这里测试返回一个list集合
     * @throws Exception
     */
    @Test
    //接口是编程
    //sqlSession对象代表一次会话  用完要关闭
    public void test2() throws Exception {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //获取接口的实现类对象
            //会为接口创建一个代理对象
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
//            Employee instance = mapper.getInstance(1);
            //模糊查询 查找返回list
//            List<Employee> empByLike = mapper.getEmpByLike("%a%");
//            empByLike.forEach(System.out::println);

            //查询一个employee对象 key 是列名 value是对应的值
//            Map<String, Object> empByReturnMap = mapper.getEmpByReturnMap(1);
//            System.out.println(empByReturnMap);

            Map<Integer, Employee> empByReturnMaps = mapper.getEmpByReturnMaps("%a%");
            System.out.println(empByReturnMaps);
        } finally {
            session.close();
        }
    }

    /**
     * 自定义返回的类型
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee emp = mapper.getEmp(2);
            sqlSession.commit();
            System.out.println(emp);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 级联查询的操作
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee emp = mapper.getEmpAndDept(3);
            sqlSession.commit();
            System.out.println(emp);
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 查找员工的分布查询通过 查找到员工的d_id再去查找部门的信息
     * @throws IOException
     */
    @Test
    public void testEmpByStep() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empBYIdStep = mapper.getEmpBYIdStep(2);
            System.out.println(empBYIdStep);
            System.out.println(empBYIdStep.getDept());
        } finally {
            sqlSession.close();
        }
    }



    /**
     * 通过部门ID  查找部门的信息
     * @throws IOException
     */
    @Test
    public void testDept() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Dept dept;
        try {
            deptMapper mapper = sqlSession.getMapper(deptMapper.class);
            dept = mapper.getDept(1);
            System.out.println(dept);
        } finally {
            sqlSession.close();
        }
    }


    /**
     * 级联查询 两张表  通过部门的ID查找当前部门下面的员工信息  dept 下面有个List<Employee>属性
     * @throws IOException
     */
    @Test
    public void testDeptById() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Dept dept;
        try {
            deptMapper mapper = sqlSession.getMapper(deptMapper.class);
            Dept deptById = mapper.getDeptById(1);
            System.out.println(deptById);
//            System.out.println(deptById.getEmployees());
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 查找部门的分布查询 通过查找到的部门的ID再去查找当前id部门下的员工信息
     * @throws IOException
     */
    @Test
    public void testDeptByIdStep() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            deptMapper mapper = sqlSession.getMapper(deptMapper.class);
            Dept deptByIdStep = mapper.getDeptByIdStep(2);
            System.out.println(deptByIdStep);
//            System.out.println(deptByIdStep.getEmployees());
        } finally {
            sqlSession.close();
        }
    }

    /**
     *  动态sql的测试  if  trim  choose  set foreach等测试
     * @throws IOException
     */
    @Test
    public void testDySql() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            employeeMapperDySql mapper = sqlSession.getMapper(employeeMapperDySql.class);

//            Employee employee = new Employee(null, "%B%", null, null);
            Employee employee = new Employee(2, "liBoss2", null, null);
//            List<Employee> empByDyIf = mapper.getEmpByDyIf(employee);
//            System.out.println(empByDyIf);

//
//            List<Employee> empByDyIf1 = mapper.getEmpByDyTrim(employee);
//            System.out.println(empByDyIf1);

            //分支查询  只会查询一个条件
//            List<Employee> empByDyChoose = mapper.getEmpByDyChoose(employee);
            //测试set
//            mapper.updateEmpByDySet(employee);
//            sqlSession.commit();
            //测试foreach查询多个
            List<Employee> empByDyForeach = mapper.getEmpByDyForeach(Arrays.asList(1,2,3,4));
            System.out.println(empByDyForeach);
//            System.out.println(empByDyChoose);
        } finally {
            sqlSession.close();
        }
    }

    /**
     *这里测试批量保存
     * @throws IOException
     */
    @Test
    public void addEmpsTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            employeeMapperDySql mapper = sqlSession.getMapper(employeeMapperDySql.class);
            List<Employee> list =new ArrayList<>();
            list.add((new Employee(null, "张三","zhangsan@qq.com","1" ,new Dept(1))));
            list.add((new Employee(null, "李四","lisi@qq.com","1" ,new Dept(1))));
            list.add((new Employee(null, "王五","wangwu@qq.com","1" ,new Dept(1))));
            mapper.addEmps(list);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }
    /**
     *   测试内置参数   parameter
     * @throws IOException
     */
    @Test
    public void getEmpByIdInnerParameter() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            employeeMapperDySql mapper = sqlSession.getMapper(employeeMapperDySql.class);
            Employee employee=new Employee();
            employee.setLastname("g");
            List<Employee> empByDyInnerParameter = mapper.getEmpByDyInnerParameter(employee);
            for (Employee employee1:empByDyInnerParameter){
                System.out.println(employee1);
            }
        } finally {
            sqlSession.close();
        }
    }
}
