package com.shoppingMall.controller;

import com.shoppingMall.service.ProductService;
import com.shoppingMall.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    @Autowired ProductService p_service;
    @GetMapping("/review")
    public String getReview(@RequestParam Integer mi_seq,@RequestParam Integer pi_seq , Model model){
        ProductInfoVO product = p_service.selectProductBySeq(pi_seq);
        model.addAttribute("product",product);


        return "/review/write";
    }
    
}
