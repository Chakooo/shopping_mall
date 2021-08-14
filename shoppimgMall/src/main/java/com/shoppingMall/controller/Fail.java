package com.shoppingMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Fail {
    @GetMapping("/fail")
    public String fail(){


        return "/fail";
    }
    
}
