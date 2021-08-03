package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ProductVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommandMapper {
    // 판매자용 추천상품
    public List<ProductInfoVO> selectRecommandProducts();
    public List<ProductInfoVO> selectRecommandSellerProd();
    public List<ProductVO> selectSellerRecommandProducts(Integer si_seq) ;
    public List<ProductVO> selectSellerNotRecommandProducts(Integer si_seq,String keyword) ;
    public void insertSellerRecommandProduct(Integer prod_seq , Integer si_seq);
    public void deleteSellerRecommandProduct(Integer prod_seq,Integer si_seq);

    //admin 웹 index용 상품 추천

    public List<ProductVO> selectNotRecommandProducts(Integer cate_seq,Integer si_seq, String keyword);
    public void insertRecommandProduct(Integer prod_seq);
    public List<ProductVO> showRecommandProducts();
    public void deleteRecommandProduct(Integer prod_seq);
    


}
