package com.shoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String getAdmin(){

        return "/admin/home";
    }
    @GetMapping("//admin/regist/check")
    public String getRegistSeller(){

        return "/admin/sellerRegist";
    }
    
}
