package com.shoppingMall.mapper;

import com.shoppingMall.vo.RegularCustomerInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DetailMapper {
    public Integer selectProductBySellerSeq(Integer prod_seq);
    public void insertRegularCustomer(RegularCustomerInfoVO vo);
    public Integer isDupRegularCustomer(Integer si_seq,Integer mi_seq);
    
}
