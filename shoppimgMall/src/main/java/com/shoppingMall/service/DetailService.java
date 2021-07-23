package com.shoppingMall.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shoppingMall.mapper.DetailMapper;
import com.shoppingMall.vo.RegularCustomerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
    @Autowired DetailMapper mapper;
    public Integer selectProductBySellerSeq(Integer prod_seq){       
       return mapper.selectProductBySellerSeq(prod_seq);

    }
    public Map<String,Object> insertRegularCustomer(RegularCustomerInfoVO vo){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        Integer result =mapper.isDupRegularCustomer(vo.getRc_si_seq(), vo.getRc_mi_seq());
    
        if(result == 1){
            resultMap.put("status", false);
            resultMap.put("message","이미 추가되어 있는 단골가게입니다.");
        }
        if(result != 1){
        mapper.insertRegularCustomer(vo);

        resultMap.put("status", true);
        resultMap.put("message", "단골가게가 추가되었습니다.");
        }
        return resultMap;
        


    }

    
}
