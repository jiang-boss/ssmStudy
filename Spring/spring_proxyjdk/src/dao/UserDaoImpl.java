package dao;

/**
 * @author jiangboss
 * @create 2021-04-26-13:46
 */
public class UserDaoImpl implements UserDao {

    @Override
    public int add(int a, int b) {
        System.out.println("add方法的执行！");
        return a+b;
    }

    @Override
    public int reduce(int a, int b) {
        System.out.println("reduce方法的执行");
        return a-b;
    }
}
