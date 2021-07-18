package com.shoppingMall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.shoppingMall.mapper.CategoryMapper;
import com.shoppingMall.mapper.RecommandMapper;
import com.shoppingMall.service.RecommandService;
import com.shoppingMall.vo.CategoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    @Autowired CategoryMapper cate_mapper;
    @Autowired RecommandService r_service; 


    
    @GetMapping("/")
    public String getMain(Model model,HttpSession session){
        List<CategoryVO> list = cate_mapper.selectCategories();
        session.setAttribute("catelist", list);        
        // model.addAttribute("catelist", list);
        model.addAttribute("reco_list",r_service.selectRecommandProducts());
        System.out.println("Main");
        return "/index";
    }
    

   
}
