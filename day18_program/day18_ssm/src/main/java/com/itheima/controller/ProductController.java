package com.itheima.controller;

import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("productList")
    @ResponseBody
    public Map<String,Object> productList(){
        Map<String,Object> map  = service.findProductMap();
        return map;
    }
}
