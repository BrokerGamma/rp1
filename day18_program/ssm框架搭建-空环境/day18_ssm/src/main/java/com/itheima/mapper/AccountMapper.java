package com.itheima.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * dao层的测试,两个方法  转入  转出
 */
public interface AccountMapper {

    public void transferIn(@Param("inName") String inName, @Param("money")double money);

    public void transferOut(@Param("outName")String outName,@Param("money")double money);
}
