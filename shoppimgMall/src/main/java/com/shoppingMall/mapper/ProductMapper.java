package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ProductInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    
   
    public String getSellerName(Integer si_seq);
    public String getProductImageFileName(String uri);
    public String getCategoryName(Integer cate_seq);
    public ProductInfoVO selectProductBySeq(Integer seq);
    
    
}
