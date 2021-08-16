package com.shoppingMall.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.shoppingMall.service.ShoppingCartService;
import com.shoppingMall.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingCartController {
    @Autowired ShoppingCartService service;

    @GetMapping("/cart")
    public String getShoppingCart(){return "redirect:/login";}



    // http://localhost/cart/아이디?dqxSrEp=123
    @GetMapping("/cart/{member_id}")
    public String getShoppingCart(@PathVariable @Nullable String member_id , @RequestParam @Nullable Integer  dqxSrEp , Model model){
    // dqxSrEp = 사용자의 db상의 mi_seq 번호
        if(member_id==null || dqxSrEp==null || member_id==""||dqxSrEp==0){          
            return "redirect:/login";
        }
        List<ProductInfoVO> list= service.selectCartProducts(dqxSrEp);
        model.addAttribute("list",list);
        return "/product/cart";
    }



   


}