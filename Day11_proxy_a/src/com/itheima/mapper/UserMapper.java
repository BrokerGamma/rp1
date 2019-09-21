package com.itheima.mapper;


import com.itheima.pojo.Order;
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
    UserMapper接口:专门对tb_user表进行增删改查
 */
public interface UserMapper {
    //根据id查询用户
    public abstract User selectUserById(@Param("id") long id);

    //查询所有用户
    public abstract List<User> selectAllUser();

    //添加用户
    public abstract void insertUser(User user);

    //修改用户
    public abstract void updateUser(User user);

    //根据id删除用户
    public abstract void deleteUser(long id);

    //根据用户名和密码查询用户
    public abstract User selectUserByUsernameAndPassoword(
            @Param("username") String username,
            @Param("password") String password);

    //需求1：查询所有男性用户，如果输入了姓名，则按照姓名模糊查找；如果没有输入姓名则不管姓名
    public abstract List<User> selectUserBySexAndName(@Param("name") String name);

    //需求2：查询所有用户，传递参数orderType，如果值为0，按照年龄升序排序，如果为1则按照年龄降序排序，否则按照ID排序
    public abstract List<User> selectUserBySort(@Param("orderType") int orderType);

    //需求3：查询所有用户，如果有姓名不为空，则按照姓名模糊查找；如果年龄也不为空，则还要满足年龄小于指定年龄
    public abstract List<User> selectUserByNameAndAge(@Param("name") String name,@Param("age") Integer age);

    //需求5：根据多个ID查询用户
    public abstract List<User> selectUserByIds(@Param("ids") List<Integer> ids);



}
