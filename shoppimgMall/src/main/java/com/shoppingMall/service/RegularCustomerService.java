package com.shoppingMall.service;


import java.lang.reflect.Member;
import java.util.List;

import com.shoppingMall.mapper.RegularCustomerMapper;
import com.shoppingMall.vo.MemberInfoVO;
import com.shoppingMall.vo.RegularCustomerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegularCustomerService {
    @Autowired RegularCustomerMapper r_mapper;
    public List<MemberInfoVO> showRegularMember(Integer si_seq){

        List<MemberInfoVO> list = r_mapper.showRegularMember(si_seq);

        return list;
    }

}
