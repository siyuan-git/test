package com.hnuc.mapper;

import com.hnuc.pojo.ProductType;
import com.hnuc.pojo.ProductTypeExample;
import com.hnuc.service.ProductTypeService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeMapper {
    int countByExample(ProductTypeExample example);

    int deleteByExample(ProductTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductTypeService> selectByExample(ProductTypeExample example);

    ProductType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByExample(@Param("record") ProductType record, @Param("example") ProductTypeExample example);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}