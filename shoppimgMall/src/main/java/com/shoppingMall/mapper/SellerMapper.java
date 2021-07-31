package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.ChartVO;
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


    // 판매현황 차트구현 mapper
    public List<ChartVO> showProdCnt(Integer si_seq);
    public List<ChartVO> showProdCntYesterDay(Integer si_seq);
    public List<ChartVO> showProdCntToDay(Integer si_seq);
    public List<ChartVO> showProdCntByDate(Integer si_seq, String date);
    public List<ChartVO> showProdCntByTerm(Integer si_seq , String term);
    public List<ChartVO> showProdCntByTermDate(Integer si_seq , String start_date ,String end_date);
    public List<ChartVO> showProdCntRank(Integer si_seq);

    //admin_page 제품리스트 count
    public Integer selectSellerProdCnt(Integer seq);
    public List<SellerInfoVO> getSellerList();
    
    

} 
