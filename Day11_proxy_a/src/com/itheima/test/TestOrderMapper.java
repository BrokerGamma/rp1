package com.itheima.test;

import com.itheima.mapper.OrderMapper;
import com.itheima.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestOrderMapper {
    //定义一个OrderMapper变量,供所有的方法使用
    private OrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        //1.使用Resources类获取字节输入流,读取mybatis的全局配置文件mybatis-config.xml
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.获取SqlSessionFactory工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.使用工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //4.使用SqlSession对象中的方法getMapper,传递接口的class文件对象,让mybatis自动创建接口的实现类对象
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    //需求1：根据订单号 查询订单的同时，查询出订单所属用户
    @Test
    public void selectOrderAndUserByNum(){
        Order order = orderMapper.selectOrderAndUserByNum("20140921001");
        System.out.println(order);
    }

    //需求2：根据订单号 查询订单，并且查询出所有订单详情及所属用户
    @Test
    public void selectOrderAndUserAndOrderitemByNum(){
        Order order = orderMapper.selectOrderAndUserAndOrderitemByNum("20140921001");
        System.out.println(order);
    }

    //需求3：根据订单号 查询订单，查询出所属用户，并且查询出订单的详情，及订单详情中的对应的商品信息
    @Test
    public void selectOrderAndUserAndOrderitemAndProductByNum(){
        Order order = orderMapper.selectOrderAndUserAndOrderitemAndProductByNum("20140921001");
        System.out.println(order);
    }
}
