package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommandMapper {
    public List<ProductInfoVO> selectRecommandProducts();
    public List<ProductVO> selectSellerRecommandProducts(Integer si_seq) ;
    public List<ProductVO> selectSellerNotRecommandProducts(Integer si_seq,String keyword) ;
    public void insertSellerRecommandProduct(Integer prod_seq , Integer si_seq);
    public void deleteSellerRecommandProduct(Integer prod_seq,Integer si_seq);
}
