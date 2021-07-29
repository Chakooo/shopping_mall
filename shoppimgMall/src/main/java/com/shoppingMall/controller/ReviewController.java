package com.shoppingMall.controller;

import java.util.List;

import com.shoppingMall.service.ProductService;
import com.shoppingMall.service.ReviewService;
import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    @Autowired ProductService p_service;
    @Autowired ReviewService r_service;


    @GetMapping("/review")
    public String getReview(@RequestParam Integer mi_seq,@RequestParam Integer pi_seq , Model model){
        ProductInfoVO product = p_service.selectProductBySeq(pi_seq);
        model.addAttribute("product",product);


        return "/review/write";
    }
    @GetMapping("/seller/review/{si_seq}")
    public String getSellerReview(@PathVariable Integer si_seq,Model model){
        List<ReviewVO> r_list = r_service.showReview(si_seq);      
        model.addAttribute("r_list", r_list);
      
        return "/seller/review";
    }  
  
    
}
