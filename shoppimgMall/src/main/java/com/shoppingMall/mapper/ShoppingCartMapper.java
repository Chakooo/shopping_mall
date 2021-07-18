package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ShoppingCartVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper {
    public void insertProduct(ShoppingCartVO vo); 
    public Integer selectCartProductCnt(ShoppingCartVO vo);
    public void updateCartProductCnt(ShoppingCartVO vo);
    public Integer selectCount(Integer mi_seq);
    public List<ProductInfoVO> selectCartProducts(Integer mi_seq);

    public void deleteCartProduct(Integer pi_seq,Integer mi_seq);
    public void increaseProductCnt(Integer pi_seq,Integer mi_seq);
    public void decreaseProductCnt(Integer pi_seq,Integer mi_seq);



    public void changeProductCnt (Integer pi_seq,Integer mi_seq,Integer cnt); // 엔터키 눌렀을때 한번에 수량조절하는 Mapper;
}
