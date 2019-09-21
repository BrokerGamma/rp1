package com.itheima.service;

import com.itheima.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    public void transfer(String inName, String outName, double money) {
        //调用mapper的转入
        mapper.transferIn(inName,money);
        //int i = 1/0;
        //调用mapper的转出
        mapper.transferOut(outName,money);
    }
}
