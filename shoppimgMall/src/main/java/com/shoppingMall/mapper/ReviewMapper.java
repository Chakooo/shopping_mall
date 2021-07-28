package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ReviewVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    public void insertReview(ReviewVO vo);
    public Integer selectMemberProdReviewCnt(Integer oi_seq);
    public Double selectProdReviewRateAvg(Integer pi_seq);
    
    
    // 리뷰정보 판매자로 가져오기
     
    public List<ReviewVO> showReview(Integer si_seq); 
}
