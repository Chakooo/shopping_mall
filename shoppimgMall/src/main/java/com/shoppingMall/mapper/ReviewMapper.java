package com.shoppingMall.mapper;

import com.shoppingMall.vo.ReviewVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    public void insertReview(ReviewVO vo);
    public Integer selectMemberProdReviewCnt(Integer oi_seq);
    public Double selectProdReviewRateAvg(Integer pi_seq);
    
}
