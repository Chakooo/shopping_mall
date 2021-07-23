package com.shoppingMall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shoppingMall.service.OrderService;
import com.shoppingMall.vo.MemberInfoVO;
import com.shoppingMall.vo.OrderInfoVO;
import com.shoppingMall.vo.OrderProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @Autowired OrderService service;

    // 고객이 주문한 주문정보표시
    @GetMapping("/member/order")
    public String getMemberOrder(Model model,HttpSession session){
        MemberInfoVO member = (MemberInfoVO)session.getAttribute("member");
        if(member ==null){
            return "redirect:/login";
        }
        
        Integer mi_seq = member.getMi_seq();
        List<OrderProductVO> list =service.selectOrderInfo(mi_seq);
        model.addAttribute("order_list",list);

        return "/member/order";
    }




    //주문배송관리  (판매자)   
    @GetMapping("/order/{seq}")
    public String getOrder(@RequestParam @Nullable Integer offset, @PathVariable Integer seq ,Model model){
        if(offset == null) offset =0;
        List<OrderInfoVO> list = service.orderInfo(offset,seq);
        Integer cnt =service.selectOrderCount();

        model.addAttribute("list",list);
        model.addAttribute("cnt",cnt);
        

        return "/order/order_list";
    }
    
}
