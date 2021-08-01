package com.shoppingMall.controller;

import java.util.List;

import com.shoppingMall.mapper.CategoryMapper;
import com.shoppingMall.service.DeliveryService;
import com.shoppingMall.service.ProductService;
import com.shoppingMall.service.SellerService;
import com.shoppingMall.vo.CategoryVO;
import com.shoppingMall.vo.DeliveryInfoVO;
import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.SellerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired CategoryMapper c_mapper;
    @Autowired ProductService p_service;
    @Autowired DeliveryService d_service;
    @Autowired SellerService s_service;
    

    // 상세페이지로 이동
    @GetMapping("/products")
    public String getProducts(@RequestParam Integer cate_seq,Model model){       
        System.out.println("ㅎㅇ");
        String cate_name = c_mapper.selectCategoryName(cate_seq);
        model.addAttribute("category", cate_name);
        List<ProductInfoVO> list = p_service.selectProductsByCategory(cate_seq);
        model.addAttribute("list", list);
        
        return "/admin/productList";
    }
    
    // admin페이지에 상품관리
    @GetMapping("/product/admin")
    public String getProduct(Model model){
        List<CategoryVO> clist = c_mapper.selectCategoryAll();
        List<DeliveryInfoVO> dlist = d_service.selectDeliveryAll();
        List<SellerInfoVO> slist = s_service.getSellerList();
   
 
         model.addAttribute("clist",clist);
         model.addAttribute("dlist", dlist);
         model.addAttribute("slist", slist);

        return "/admin/productList";
    }
    
    
}
