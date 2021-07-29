package com.shoppingMall.controller;

import java.util.List;

import com.shoppingMall.mapper.ProductMapper;
import com.shoppingMall.mapper.SellerMapper;
import com.shoppingMall.service.CategoryService;
import com.shoppingMall.service.DeliveryService;
import com.shoppingMall.service.ReviewService;
import com.shoppingMall.service.SellerService;
import com.shoppingMall.vo.CategoryVO;
import com.shoppingMall.vo.ChartVO;
import com.shoppingMall.vo.DeliveryInfoVO;
import com.shoppingMall.vo.ReviewVO;
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
    @Autowired SellerMapper seller_mapper;
    @Autowired ProductMapper p_mapper;
    @Autowired ReviewService r_service;
    
    

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

    @GetMapping("/seller/home/{si_seq}")
    public String getHome(@PathVariable Integer si_seq,Model model){
        if(si_seq == null){
            return "/";
        }
        List<ReviewVO> r_list = r_service.showReview(si_seq);
        model.addAttribute("r_list", r_list);
        
           
        return "/seller/home";  
    }

    @GetMapping("/seller/product/{si_seq}")
    public String productManagement(Model model, @PathVariable Integer si_seq){
        if(si_seq==null){
            return "redirect:/seller/login";
        }
        
        List<CategoryVO> clist = cate_service.selectCategoryAll();
        List<DeliveryInfoVO> dlist = delivery_service.selectDeliveryAll();
        List<SellerInfoVO> slist = seller_service.selectSellerAll();
   
 
         model.addAttribute("clist",clist);
         model.addAttribute("dlist", dlist);
         model.addAttribute("slist", slist);
        return "/seller/product";
    }
    @GetMapping("/seller/product")
    public String productManagement(){
      // seller/chart로 직접 입력시 로그인으로 보내는 처리
       
      return "redirect:/seller/login";
    }
    
   
    @GetMapping("/seller/chart")
    public String getProductChart(){
            // seller/chart로 직접 입력시 로그인으로 보내는 처리
        return "redirect:/seller/login";
    } 
       
    @GetMapping("/seller/chart/{si_seq}")
    public String getProductChart(Model model,@PathVariable Integer si_seq){
               if(si_seq==null){
                   return "redirect:/seller/login";
               }
              List<String> prod_name= p_mapper.selectProdNameBySeller(si_seq);
              model.addAttribute("prod_name", prod_name);

              List<ChartVO> list = seller_mapper.showProdCnt(si_seq);
              model.addAttribute("list_size",list.size());
              model.addAttribute("list",list);

        
              
        return "/seller/chart";
    }  
           
   
}
