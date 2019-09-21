package com.itheima.service;

import com.itheima.mapper.ProductMapper;
import com.itheima.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;

    /**
     * 目的:该方法查询数据库所有商品,并封装一个Map集合的数据返回.
     * 思路:
     * 1.mapper查询数据库所有的商品得到一个List<Product>
     * 2.准备一个Map<String,Object>
     * 3.准备一个List<String> 存放xData 商品的名称的集合
     * 4.准备一个List<Long> 存放seriesData 商品的数量
     * 5.循环List<Product> 循环中设置xData集合  设置seriesData集合数据
     * 6.循环结束后 两个list put到map集合中
     * 7.return map
     */
    public Map<String, Object> findProductMap() {

        //1.mapper查询数据库所有的商品得到一个List<Product>
        List<Product> list  = mapper.queryProducts();
        //2.准备一个Map<String,Object>
        Map<String,Object> map = new HashMap<String, Object>();
        //3.准备一个List<String> 存放xData 商品的名称的集合
        List<String> xDataList = new ArrayList<String>();
        //4.准备一个List<Long> 存放seriesData 商品的数量
        List<Long> seriesDataList = new ArrayList<Long>();
        //5.循环List<Product> 循环中设置xData集合  设置seriesData集合数据
        for (Product product : list) {
            xDataList.add(product.getPname());
            seriesDataList.add(product.getNum());
        }
        //6.循环结束后 两个list put到map集合中
        map.put("xData",xDataList);
        map.put("seriesData",seriesDataList);
        //7.return map
        return map;
    }
}
