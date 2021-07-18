package com.shoppingMall.mapper;

import com.shoppingMall.vo.DeliveryInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    public DeliveryInfoVO selectDeliveryBySeq(Integer seq);
    
}
