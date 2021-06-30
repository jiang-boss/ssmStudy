package service;

import dao.UserDao;
import dao.UserDaoImpl;

import java.lang.reflect.*;
import java.util.Arrays;
/**
 * @author jiangboss
 * @create 2021-04-26-14:04
 * jdk的动态代理
 */
public class UserProxy {
    public static void main(String[] args) {
        //创建接口实现类的代理对象
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        //三个参数 1.类加载器 2.增强方法所在的类  这个类实现的接口  支持多个接口 3.实现这个InvocationHandler接口 创建代理对象 写增强的方法

        //创建接口实现类的代理对象
        UserDao o = (UserDao) Proxy.newProxyInstance(UserProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDaoImpl));

        int add = o.reduce(3, 4);//调用方法就会处理invoke方法
        System.out.println(add);
    }
}

//创建代理对象  要实现invocationHandler接口 实现invoke方法 这里面写增强的方法
class UserDaoProxy implements InvocationHandler {
    //这里的object指的是要为哪个对象增强就传入哪个对象
    Object object;
    //有参构造传递
    public UserDaoProxy(Object obj) {
        this.object = obj;
    }
    /**
     * @param proxy 代理的对象
     * @param method 当前的方法
     * @param args 当前的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //处理增强的代码部分
        System.out.println("方法之前的处理 方法是+" + method.getName()+"传递的参数:"+ Arrays.toString(args));

        Object invoke = method.invoke(object, args);


        System.out.println("方法之后的的处理 方法是+" +method.getName());
        return invoke;
    }
}
