package com.shoppingMall.controller;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String getAdmin(HttpSession session){
        Integer grade =(Integer)session.getAttribute("grade");
        System.out.println("등급 :  "+ grade);
        if(grade != 99){
            return "/";
        
        }
        return "/admin/productList";
    }
    @GetMapping("//admin/regist/check")
    public String getRegistSeller(){

        return "/admin/sellerRegist";
    }
    
}
