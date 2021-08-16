package com.shoppingMall.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import com.shoppingMall.mapper.ReviewMapper;
import com.shoppingMall.vo.ReviewAnswerVO;
import com.shoppingMall.vo.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewMapper mapper;

    public List<ReviewVO> showReview(Integer si_seq) {
        List<ReviewVO> list = mapper.showReview(si_seq);
        SimpleDateFormat recvSimpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        for (int i = 0; i < list.size(); i++) {
            String resultMod = recvSimpleFormat.format(list.get(i).getRev_mod_dt());
            String resultReg = recvSimpleFormat.format(list.get(i).getRev_reg_dt());
            list.get(i).setResult_reg_dt(resultReg);
            list.get(i).setResult_mod_dt(resultMod);
        }
        return list;
    }

    public ReviewVO showReviewBySeq(Integer si_seq, Integer rev_seq) {
        ReviewVO r_vo = mapper.showReviewBySeq(si_seq, rev_seq);
        SimpleDateFormat recvSimpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);

        String resultMod = recvSimpleFormat.format(r_vo.getRev_reg_dt());
        String resultReg = recvSimpleFormat.format(r_vo.getRev_reg_dt());
        r_vo.setResult_reg_dt(resultReg);
        r_vo.setResult_mod_dt(resultMod);

        return r_vo;
    }

    public void insertReviewAnswer(ReviewAnswerVO vo) {

        // 백단 Null 값 예외처리해서 mybatis 로 보낼것

        mapper.insertReviewAnswer(vo);
    }

    public ReviewAnswerVO selectReviewAnsewer(Integer si_seq, Integer rev_seq) {
        ReviewAnswerVO list = mapper.selectReviewAnsewer(si_seq, rev_seq);

        return list;
    }

    public void updateReviewStatus(Integer rev_seq, Integer status) {
        mapper.updateReviewStatus(rev_seq, status);
    }

    public void deleteReviewAnswer(Integer rev_seq) {
        mapper.deleteReviewAnswer(rev_seq);
    }

    public void updateReviewAnswer(ReviewAnswerVO vo) {
        mapper.updateReviewAnswer(vo);
    }

    public Integer selectSellerSeq(Integer prod_seq) {
        return mapper.selectSellerSeq(prod_seq);
    }

    public List<ReviewVO> selectReviewByProd(Integer prod_seq) {
        List<ReviewVO> list = mapper.selectReviewByProd(prod_seq);
        SimpleDateFormat recvSimpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        for (int i = 0; i < list.size(); i++) {
            String resultMod = recvSimpleFormat.format(list.get(i).getRev_mod_dt());
            String resultReg = recvSimpleFormat.format(list.get(i).getRev_reg_dt());
            list.get(i).setResult_reg_dt(resultReg);
            list.get(i).setResult_mod_dt(resultMod);
        }
        return list;
    }

    public List<ReviewVO> selectReviewByMember(Integer seq) {
        List<ReviewVO> list = mapper.selectReviewByMember(seq);
        SimpleDateFormat recvSimpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        for (int i = 0; i < list.size(); i++) {
            String resultMod = recvSimpleFormat.format(list.get(i).getRev_mod_dt());
            String resultReg = recvSimpleFormat.format(list.get(i).getRev_reg_dt());
            list.get(i).setResult_reg_dt(resultReg);
            list.get(i).setResult_mod_dt(resultMod);
            
        }
        return list;

    }

    public ReviewAnswerVO selectAnswerBySeq(Integer seq) {
        return mapper.selectAnswerBySeq(seq);
    }
}
