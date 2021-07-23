package com.shoppingMall.controller;

import java.util.List;

import com.shoppingMall.service.RegularCustomerService;
import com.shoppingMall.vo.MemberInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RegularCustomerController {
    @Autowired RegularCustomerService r_service;
    @GetMapping("seller/regular/{si_seq}")
    public String getRegulaCustomer(@PathVariable Integer si_seq , Model model){
        
        List<MemberInfoVO> list = r_service.showRegularMember(si_seq);
        model.addAttribute("list",list);
        
        return "/seller/regular";
    }
    
}
