package com.itheima.test;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

/*
    UserMapper接口的测试类
 */
public class TestUserMapper {
    //定义UserMapper变量,供所有的测试方法使用
    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        //1.使用Resources类获取字节输入流,读取mybatis的全局配置文件mybatis-config.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.使用工厂类对象创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //4.使用SqlSession对象中方法getMapper,参数传递UserMapper接口的class文件对象,让mybatis帮助我们创建UserMapper接口的实现类对象
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    //根据id查询用户
    @Test
    public void selectUserById(){
        User user = userMapper.selectUserById(3L);
        System.out.println(user);
    }

    //查询所有用户
    @Test
    public void selectAllUser(){
        List<User> users = userMapper.selectAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    //添加用户
    @Test
    public void insertUser(){
        //创建User对象,并赋值
        User user = new User();
        user.setuserName("laoli");
        user.setPassword("2222");
        user.setName("老李");
        user.setSex(1);
        user.setAge(20);
        userMapper.insertUser(user);
        //想要使用添加新数据的主键
        System.out.println(user.getId());//null  11
    }

    //修改用户
    @Test
    public void updateUser(){
        //先根据id查询出一个用户,在修改用户的信息
        User user = userMapper.selectUserById(2L);
        //给user对象重新赋值
        user.setuserName("zhaosi");
        user.setPassword("4444");
        user.setName("赵四");
        user.setAge(44);
        user.setSex(1);
        userMapper.updateUser(user);
    }

    //根据id删除用户
    @Test
    public void deleteUser(){
        userMapper.deleteUser(2L);
    }

    //根据用户名和密码查询用户
    @Test
    public void selectUserByUsernameAndPassoword(){
        User user = userMapper.selectUserByUsernameAndPassoword("liuyan", "1234");
        System.out.println(user);
    }

    //需求1：查询所有男性用户，如果输入了姓名，则按照姓名模糊查找；如果没有输入姓名则不管姓名
    @Test
    public void selectUserBySexAndName(){
        List<User> list = userMapper.selectUserBySexAndName(null);
        for (User user : list) {
            System.out.println(user);
        }
    }

    //需求2：查询所有用户，传递参数orderType，如果值为0，按照年龄升序排序，如果为1则按照年龄降序排序，否则按照ID排序
    @Test
    public void selectUserBySort(){
        List<User> users = userMapper.selectUserBySort(11);
        for (User user : users) {
            System.out.println(user);
        }
    }

    //需求3：查询所有用户，如果有姓名不为空，则按照姓名模糊查找；如果年龄也不为空，则还要满足年龄小于指定年龄
    @Test
    public void selectUserByNameAndAge(){
        List<User> list = userMapper.selectUserByNameAndAge(null, null);
        for (User user : list) {
            System.out.println(user);
        }
    }

    //需求4：修改用户信息，如果某字段为null，则不修改这个字段
    @Test
    public void updateUser2(){
        User user = new User();
        user.setId(3L);
        /*user.setuserName("xiaoshenyang");
        user.setPassword("6666");
        user.setName("小沈阳");*/
        user.setName("宋小宝");
        userMapper.updateUser(user);
    }

    //需求5：根据多个ID查询用户
    @Test
    public void selectUserByIds(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(10);
        List<User> users = userMapper.selectUserByIds(list);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
