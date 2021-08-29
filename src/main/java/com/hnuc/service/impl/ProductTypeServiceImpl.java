package com.hnuc.service.impl;


import com.hnuc.mapper.ProductTypeMapper;
import com.hnuc.pojo.ProductTypeExample;
import com.hnuc.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductTypeService> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
