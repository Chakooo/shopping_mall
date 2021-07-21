package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.LoginVO;
import com.shoppingMall.vo.SellerInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerMapper {
    public void insertSeller(SellerInfoVO vo);
    public Integer selectSellerById(String id);
    public Integer selectSellerByEmail(String email);
    public List<SellerInfoVO> selectSellerAll();



    // 판매자 로그인
    public Integer loginSeller(LoginVO vo);
    // 판매자 정보담기
    public SellerInfoVO selectSellerInfoById(String id);


}
