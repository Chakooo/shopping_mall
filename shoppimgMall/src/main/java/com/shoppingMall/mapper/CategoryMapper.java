package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.CategoryVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    public List<CategoryVO> selectCategories();
    public void insertCategory(String name);
    public Integer isDuplicateCategory(String name);
    public List<CategoryVO> selectCategoryAll();
    public void deleteCategory(Integer seq);
    public String selectCategoryName(Integer seq);
    public Integer selectCateProdCnt(Integer seq);    

    
}
