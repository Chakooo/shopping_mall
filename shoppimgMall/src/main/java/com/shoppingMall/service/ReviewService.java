package com.shoppingMall.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.shoppingMall.mapper.ReviewMapper;
import com.shoppingMall.vo.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired ReviewMapper mapper;
    public List<ReviewVO> showReview(Integer si_seq){
        List<ReviewVO> list = mapper.showReview(si_seq);
        SimpleDateFormat recvSimpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        for(int i=0; i<list.size();i++){
            String resultMod=recvSimpleFormat.format(list.get(i).getRev_mod_dt());
            String resultReg=recvSimpleFormat.format(list.get(i).getRev_reg_dt());
           
            list.get(i).setResult_reg_dt(resultReg);
            list.get(i).setResult_mod_dt(resultMod);

        }


        return list;
    }
}
