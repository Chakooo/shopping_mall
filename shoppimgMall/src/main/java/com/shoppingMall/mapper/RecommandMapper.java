package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ProductInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommandMapper {
    public List<ProductInfoVO> selectRecommandProducts();
    

}
