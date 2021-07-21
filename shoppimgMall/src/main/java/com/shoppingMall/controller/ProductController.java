package com.shoppingMall.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.shoppingMall.mapper.CategoryMapper;
import com.shoppingMall.service.ProductService;
import com.shoppingMall.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired CategoryMapper c_mapper;
    @Autowired ProductService p_service;
    @GetMapping("/products")
    public String getProducts(@RequestParam Integer cate_seq,Model model){
        String cate_name = c_mapper.selectCategoryName(cate_seq);
        model.addAttribute("category", cate_name);
        List<ProductInfoVO> list = p_service.selectProductsByCategory(cate_seq);
        model.addAttribute("list", list);

        return "/product/list";
    }
    
}
