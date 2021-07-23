package com.shoppingMall.controller;

import com.shoppingMall.mapper.DeliveryMapper;
import com.shoppingMall.mapper.ReviewMapper;
import com.shoppingMall.service.DetailService;
import com.shoppingMall.service.ProductService;
import com.shoppingMall.vo.DeliveryInfoVO;
import com.shoppingMall.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailController {
    @Autowired ProductService service;
    @Autowired DeliveryMapper d_mapper;
    @Autowired ReviewMapper r_mapper;
    @Autowired DetailService d_service;
    @GetMapping("/detail")
    public String getDetail(@RequestParam Integer prod_seq , Model model){
        ProductInfoVO item = service.selectProductBySeq(prod_seq);
        model.addAttribute("product",item);

        Integer i = item.getPi_di_seq();
        DeliveryInfoVO delivery = d_mapper.selectDeliveryBySeq(i);
        model.addAttribute("delivery", delivery);

        Integer pi_seq = item.getPi_seq();
        System.out.println(pi_seq);
        Double rate =  r_mapper.selectProdReviewRateAvg(pi_seq);
        if(rate == null){
           rate = 0.0;
        };
        Integer i_rate = (int)Math.round(rate);        
        model.addAttribute("rate", i_rate);

        Integer si_seq= d_service.selectProductBySellerSeq(prod_seq);
        model.addAttribute("si_seq", si_seq);

        return "/detail/info";
    }   
}
