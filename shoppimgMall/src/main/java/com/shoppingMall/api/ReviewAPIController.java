package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shoppingMall.mapper.ReviewMapper;
import com.shoppingMall.service.ReviewService;
import com.shoppingMall.vo.ReviewAnswerVO;
import com.shoppingMall.vo.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewAPIController {
    @Autowired
    ReviewMapper r_mapper;
    @Autowired
    ReviewService r_service;

    @PostMapping("/review/write")
    public Map<String, Object> postReviewWrite(@RequestBody ReviewVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        r_mapper.insertReview(vo);
        resultMap.put("status", true);
        resultMap.put("message", "리뷰등록가 성공적으로 등록되었습니다.");
        return resultMap;
    }

    @GetMapping("/review/select")
    public Map<String,Object> selectReviewAnsewer(@RequestParam Integer si_seq , @RequestParam Integer rev_seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
       ReviewAnswerVO data =  r_service.selectReviewAnsewer(si_seq, rev_seq);
       
        
       resultMap.put("data", data);
       resultMap.put("status",true);       
       return resultMap;    
}
@PostMapping("/review/answer/regist")
    public Map<String, Object> postReviewWrite(@RequestBody ReviewAnswerVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        r_service.insertReviewAnswer(vo);
        resultMap.put("status", true);
        resultMap.put("message", "리뷰등록가 성공적으로 등록되었습니다.");
        return resultMap;
    }
    @PatchMapping("/review/status/update")
    public Map<String, Object> updateReviewStatus(@RequestParam Integer rev_seq, @RequestParam Integer status) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        r_service.updateReviewStatus(rev_seq,status);
        resultMap.put("status", true);
        return resultMap;
    }
    @DeleteMapping("/review/delete")
    public Map<String, Object> deleteReviewAnswer(@RequestParam Integer rev_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        r_service.deleteReviewAnswer(rev_seq);
        resultMap.put("status", true);
        resultMap.put("message","삭제되었습니다.");
        return resultMap;
    }
    
    @PatchMapping("/review/answer/update")
    public Map<String, Object> updateReviewAnswer(@RequestBody ReviewAnswerVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        r_service.updateReviewAnswer(vo);
        resultMap.put("status", true);
        resultMap.put("message","수정되었습니다.");
        return resultMap;
    }
}
