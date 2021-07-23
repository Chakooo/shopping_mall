package com.shoppingMall.api;

import java.util.Map;

import com.shoppingMall.service.DetailService;
import com.shoppingMall.vo.RegularCustomerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailAPIController {
    @Autowired DetailService d_service;
 
    @PostMapping("/regular/regist")
    public Map<String,Object> registRegular(@RequestBody RegularCustomerInfoVO vo){
        Map<String,Object> resultMap =  d_service.insertRegularCustomer(vo);
       
        return resultMap;
        
    }
}
