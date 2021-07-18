package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.CategoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    public List<CategoryVO> selectCategories();

    
}
