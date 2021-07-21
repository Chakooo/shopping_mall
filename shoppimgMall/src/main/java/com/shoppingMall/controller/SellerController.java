package com.shoppingMall.controller;

import java.util.List;

import com.shoppingMall.service.CategoryService;
import com.shoppingMall.service.DeliveryService;
import com.shoppingMall.service.SellerService;
import com.shoppingMall.vo.CategoryVO;
import com.shoppingMall.vo.DeliveryInfoVO;
import com.shoppingMall.vo.SellerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class SellerController {
    @Autowired CategoryService  cate_service; 
    @Autowired DeliveryService delivery_service;
    @Autowired SellerService seller_service;

    @GetMapping("/seller/join")
    public String getSeller(){
        return "/seller/join";
    }
    @GetMapping("/seller/login")
    public String getLogin(){
        return "/seller/login";
    }

    @GetMapping("/seller/home")
    public String getHome(){

        return "redirect:/seller/login";
    }

    @GetMapping("/seller/home/{seller_id}")
    public String getHome(@PathVariable String seller_id){
        if(seller_id==null){
            return "redirect:/seller/join";
        }
        return "/seller/home";
    }

    @GetMapping("/seller/product")
    public String productManagement(Model model){
        List<CategoryVO> clist = cate_service.selectCategoryAll();
        List<DeliveryInfoVO> dlist = delivery_service.selectDeliveryAll();
        List<SellerInfoVO> slist = seller_service.selectSellerAll();
   
 
         model.addAttribute("clist",clist);
         model.addAttribute("dlist", dlist);
         model.addAttribute("slist", slist);
        return "/seller/product";
    }

    
}
