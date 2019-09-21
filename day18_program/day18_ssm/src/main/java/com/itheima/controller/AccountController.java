package com.itheima.controller;

import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {


    /*
        用户访问的时候: localhost:8080/transfer.action?inName=aaa&outName=bbb&money=500
     */

    @Autowired
    private AccountService service;

    //转账的方法
    @RequestMapping("transfer")
    public String transfer(String inName,String outName, double money){
        service.transfer(inName,outName,money);

        //页面跳转成功页面
        return "success";  //走视图解析器
    }
}
