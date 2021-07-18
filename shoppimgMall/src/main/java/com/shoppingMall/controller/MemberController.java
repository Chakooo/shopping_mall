package com.shoppingMall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/login")
    public String getLogin(){



        return "/member/login";
    }
    @GetMapping("/join")
    public String getJoin(){

        return "/member/join";
    }
    @GetMapping("/member/logout")
    public String getLogout(HttpSession session){
        session.invalidate();//invalidate << 무효화.
        return "redirect:/";
    }
}
