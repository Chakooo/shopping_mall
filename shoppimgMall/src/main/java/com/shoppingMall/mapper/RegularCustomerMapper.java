package com.shoppingMall.mapper;


import java.util.List;

import com.shoppingMall.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegularCustomerMapper {
    public List<MemberInfoVO> showRegularMember(Integer si_seq);
    
}
