package com.hnuc.test;

import com.hnuc.mapper.ProductInfoMapper;
import com.hnuc.pojo.ProductInfo;
import com.hnuc.pojo.vo.ProductInfoVo;
import com.hnuc.utile.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLOutput;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class MyTest {
    @Test
    public void testMD5(){
        String mi = MD5Util.getMD5("000000");
        System.out.println("mi = " + mi);
    }
    @Autowired
    ProductInfoMapper mapper;
    @Test
    public void testSelectCondition(){

        ProductInfoVo vo = new ProductInfoVo();
        //vo.setPname("4");
        //vo.setTypeid(3);
       // vo.setLprice(3000);
        vo.setHprice(4000);
        List<ProductInfo> list = mapper.selectCondition(vo);
        list.forEach(productInfo -> System.out.println(productInfo));
    }
}
