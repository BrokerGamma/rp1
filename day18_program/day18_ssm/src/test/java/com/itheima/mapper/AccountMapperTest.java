package com.itheima.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class AccountMapperTest {

    @Autowired
    private AccountMapper mapper;

    @Test
    public void transferInTest() {
        mapper.transferIn("aaa",100);
    }

    @Test
    public void transferOutTest() {
        mapper.transferOut("bbb",100);
    }
}