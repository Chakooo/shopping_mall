package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ReviewAnswerVO;
import com.shoppingMall.vo.ReviewVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    public void insertReview(ReviewVO vo);
    public Integer selectMemberProdReviewCnt(Integer oi_seq);
    public Double selectProdReviewRateAvg(Integer pi_seq);
    
    
    // 리뷰정보 판매자로 가져오기
     
    public List<ReviewVO> showReview(Integer si_seq); 
    public ReviewVO showReviewBySeq(Integer si_seq,Integer rev_seq);

    // 리뷰에 대한 판매자의 리뷰답변 달기

    public void insertReviewAnswer(ReviewAnswerVO vo);
    public ReviewAnswerVO selectReviewAnsewer (Integer si_seq,Integer rev_seq);
    public void updateReviewStatus(Integer rev_seq);


    
}
