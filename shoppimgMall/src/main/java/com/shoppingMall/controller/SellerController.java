package com.shoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SellerController {

    @GetMapping("/seller/join")
    public String getSeller(){

        return "/seller/join";
    }
    
}
