package com.shoppingMall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shoppingMall.service.MemberService;
import com.shoppingMall.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @Autowired MemberService service;

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
    @GetMapping("/member/list")
    public String getMemberList(Model model){
        List<MemberInfoVO> resultList= service.selectMemberAll();
        model.addAttribute("list", resultList);
        return "/admin/list";
    }
}
