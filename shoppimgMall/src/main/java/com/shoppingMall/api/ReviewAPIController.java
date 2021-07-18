package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shoppingMall.mapper.ReviewMapper;
import com.shoppingMall.vo.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewAPIController {
    @Autowired ReviewMapper mapper;
    @PostMapping("/review/write")
    public Map<String,Object> postReviewWrite(@RequestBody ReviewVO vo){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        mapper.insertReview(vo);       
        resultMap.put("status", true);
        resultMap.put("message","리뷰등록가 성공적으로 등록되었습니다.");
        return resultMap;
    }

    
}
