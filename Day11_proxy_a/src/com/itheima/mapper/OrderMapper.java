package com.itheima.mapper;

import com.itheima.pojo.Order;
import org.apache.ibatis.annotations.Param;

/*
    OrderMapper接口:用于对order表进行增删改查
 */
public interface OrderMapper {

    //需求1：根据订单号 查询订单的同时，查询出订单所属用户
    public abstract Order selectOrderAndUserByNum(@Param("num") String num);

    //需求2：根据订单号 查询订单，并且查询出所有订单详情及所属用户
    public abstract Order selectOrderAndUserAndOrderitemByNum(@Param("num") String num);

    //需求3：根据订单号 查询订单，查询出所属用户，并且查询出订单的详情，及订单详情中的对应的商品信息
    public abstract Order selectOrderAndUserAndOrderitemAndProductByNum(@Param("num") String num);
}
