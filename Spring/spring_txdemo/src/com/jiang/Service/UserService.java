package com.jiang.Service;
import com.jiang.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
/**
 * @author jiangboss
 * @create 2021-04-25-16:24
 *事务添加到javaEE三层架构中Service层中（业务逻辑层）
 * spring管理事务的两种方式  编程式管理    声明式事务管理
 *声明式事务管理
 * 1.基于注解文件方式
 * 2.基于xml配置文件方式
 * spring声明式事务管理 底层使用aop原理
 *spring事务管理api
 *    提供一个接口代表事务管理器这个接口针对不同的框架提供不同的实现类
 *    使用 注解式事务管理
 *      1.
 *      声明式事务管理参数配置
 *      propagation 事务传播行为 （有七种） 多事务的方法直接调用 这个过程中事务是如何管理的
 *           required  a事务调用b方法 如果b有事务那么b方法在事务a中进行 要是b没有事务则会开启一个事务 在a事务中执行
 *           required_new  无论b方法有没有事务都会新创建一个事务在a事务中执行
 *      ioslation 事务隔离级别 事务有特性成为隔离性 多事务操作之间不会产生影响 不考虑隔离性会产生很多问题
 *                 有三个读的问题：脏读 不可重复读  幻读（虚读）
 *                   脏读 ：一个未提交的事务读取到了另一个未提交的事务的数据
 *                  不可重复读：一个未提交的事务读取到了另一个提交的事物修改的数据
 *                  幻读：一个未提交的事务读取到另一个提交事务的添加的数据
 *                  ***通过事物的隔离性 解决三个问题
 *                               脏读   不可重复读   幻读
 *                  读未提交       有       有        有
 *                  读已提交       无       有        有
 *                  可重复读       无       无        有
 *                  串行化读       无       无        无
 *      timeout超时时间： 设置事务在规定的时间内提交  不提交就会回滚
 *      readonly是否只读： 读：查询操作  写：增删改   默认FALSE  改为TRUE 就是只读
 *      rollbackFor 回滚   设置出现那些异常回滚
 *      norollbackFor不回滚： 设置出现哪些 异常 不会回滚
 *      Xml声明管理
 */
@Service
//添加事务注解可以加在类的上面 也可以加在方法上面 一行注解就能解决事务管理的一些操作
//mysql 的默认隔离级别是   REPEATABLE_READ  可重复读
//@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
//@Transactional
public class UserService {
    @Autowired//根据类型注入 根据UserDao类型注入！
    private UserDao userDao;
    //处理事物的操作
    public void accountMoney(){
//        try {
            //1.开启事务
            //2.执行事务
            userDao.reduceMoney();
            //模拟异常转账失败
//            int a=10/0;//加个异常来检验事务会不会回滚
            userDao.addMoney();
            //3.没有事务提交事务
//        }catch (Exception e){
//            //4.回滚事务
//        }
    }
}
