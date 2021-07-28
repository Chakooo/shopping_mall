package com.shoppingMall.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.mapper.SellerMapper;
import com.shoppingMall.utils.AESAlgorithm;
import com.shoppingMall.vo.ChartVO;
import com.shoppingMall.vo.LoginVO;
import com.shoppingMall.vo.ReviewVO;
import com.shoppingMall.vo.SellerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerMapper mapper;

    public boolean insertSeller(SellerInfoVO vo) {

        Integer cntId = mapper.selectSellerById(vo.getSi_id()); // 아이디 중복 검사 먼저 실행
        Integer cntEmail = mapper.selectSellerByEmail(vo.getSi_email());

        if (cntId != 0) {
            return false;
        }
        if (cntEmail != 0) {
            return false;
        }
        if (vo.getSi_id() == "" || vo.getSi_id() == null || vo.getSi_id().length() < 4) {
            return false;
        }
        if (vo.getSi_pwd() == "" || vo.getSi_pwd() == null || vo.getSi_pwd().length() < 6) {
            return false;
        }
        if (vo.getSi_name() == "" || vo.getSi_name() == null) {
            return false;
        }
        if (vo.getSi_phone() == "" || vo.getSi_phone() == null) {
            return false;
        }
        if (vo.getSi_address() == "" || vo.getSi_address() == null) {
            return false;
        }
        if (vo.getSi_email() == "" || vo.getSi_email() == null) {
            return false;
        }
        String pwd = vo.getSi_pwd();
        try {
            pwd = AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vo.setSi_pwd(pwd);
        System.out.println(pwd);

        mapper.insertSeller(vo);
        return true;
    }

    public boolean isDuplicateId(String id) {
        Integer r = mapper.selectSellerById(id);
        if (r == 0) {
            return false; // 해당 아이디로 가입된 가입자가 없음.
        }
        return true; // 해당 아이디로 가입된 가입자가 있음.
    }

    public boolean isDuplicatedEmail(String email) {

        return mapper.selectSellerByEmail(email) > 0;
    }

    public Map<String, Object> loginSeller(LoginVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        String pwd = vo.getPwd();
        try {
            pwd = AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        vo.setPwd(pwd);
        Integer result = mapper.loginSeller(vo);
        if (result == 1) {
            resultMap.put("status", true);
            SellerInfoVO seller = mapper.selectSellerInfoById(vo.getId());
            resultMap.put("si_seq",seller.getSi_seq());
            resultMap.put("seller", seller);
        } else {
            resultMap.put("status", false);
            resultMap.put("message", "아이디 또는 비밀번호가 틀렸습니다.");
        }
        return resultMap;
    }

    public List<SellerInfoVO> selectSellerAll() {
        List<SellerInfoVO> list = mapper.selectSellerAll();
        // for(int i=0; i<list.size();i++){
        // Integer cnt = mapper.selectSellerProdCnt(list.get(i).getSi_seq());
        // list.get(i).setSeller_prod_cnt(cnt);
        // }
        return list;
    }

    // 차트 표시위한 판매량 조회
    public Map<String,Object> showProdCnt(Integer si_seq) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        List<ChartVO> list = mapper.showProdCnt(si_seq);

        List<Integer> prod_cnt = new ArrayList<Integer>();
        List<String> p_name = new ArrayList<String>();

        for(ChartVO vo : list){
            prod_cnt.add(vo.getPc_count());
            p_name.add(vo.getPi_name());
            
        }
        resultMap.put("prod_cnt", prod_cnt);
        resultMap.put("p_name", p_name);
        resultMap.put("allCnt",list.size());
        resultMap.put("status", true);
        

        return resultMap;
    }

    public Map<String,Object> showProdCntYesterDay(Integer si_seq) {
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        List<ChartVO> list = mapper.showProdCntYesterDay(si_seq);
        List<ChartVO> list2 = mapper.showProdCntToDay(si_seq);
        List<ChartVO> name  = mapper.showProdCnt(si_seq);

        List<Integer> y_prod_cnt = new ArrayList<Integer>();
        List<Integer> t_prod_cnt = new ArrayList<Integer>();
        List<String> all_name = new ArrayList<String>();
       

        for(ChartVO vo : list){
            y_prod_cnt.add(vo.getPc_count());
        }
        for(ChartVO vo : list2){
            t_prod_cnt.add(vo.getPc_count());
        }
        for(ChartVO vo : name){
            all_name.add(vo.getPi_name());
        }
        resultMap.put("y_prod_cnt", y_prod_cnt);
        resultMap.put("t_prod_cnt", t_prod_cnt);
        resultMap.put("all_name", all_name);
        resultMap.put("allCnt",list.size());
        resultMap.put("status", true);
        

        return resultMap;
    }

    public Map<String,Object> showProdCntByDate(Integer si_seq, String date){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();       
        System.out.println(date);
        List<ChartVO> list = mapper.showProdCntByDate(si_seq,date);

        List<Integer> prod_cnt = new ArrayList<Integer>();
        List<String> p_name = new ArrayList<String>();

        for(ChartVO vo : list){
            prod_cnt.add(vo.getPc_count());
            p_name.add(vo.getPi_name());
            
        }
        resultMap.put("prod_cnt", prod_cnt);
        resultMap.put("p_name", p_name);
        resultMap.put("allCnt",list.size());
        resultMap.put("status", true);
        

        return resultMap;

    }
    public Map<String,Object> showProdCntByTerm(Integer si_seq,String term){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();       
        List<ChartVO> list = mapper.showProdCntByTerm(si_seq,term);

        List<Integer> prod_cnt = new ArrayList<Integer>();
        List<String> p_name = new ArrayList<String>();

        for(ChartVO vo : list){
            prod_cnt.add(vo.getPc_count());
            p_name.add(vo.getPi_name());
            
        }
        resultMap.put("prod_cnt", prod_cnt);
        resultMap.put("p_name", p_name);
        resultMap.put("allCnt",list.size());
        resultMap.put("status", true);
        

        return resultMap;

    }
    public Map<String,Object> showProdCntByTermDate(Integer si_seq , String start_date ,String end_date){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();       
        List<ChartVO> list = mapper.showProdCntByTermDate(si_seq,start_date,end_date);

        List<Integer> prod_cnt = new ArrayList<Integer>();
        List<String> p_name = new ArrayList<String>();

        for(ChartVO vo : list){
            prod_cnt.add(vo.getPc_count());
            p_name.add(vo.getPi_name());
            
        }
        resultMap.put("prod_cnt", prod_cnt);
        resultMap.put("p_name", p_name);
        resultMap.put("allCnt",list.size());
        resultMap.put("status", true);
        

        return resultMap;


    }
    
    public Map<String,Object> showProdCntRank(Integer si_seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();       
        List<ChartVO> list = mapper.showProdCntRank(si_seq);

        List<Integer> prod_cnt = new ArrayList<Integer>();
        List<String> p_name = new ArrayList<String>();

        for(ChartVO vo : list){
            prod_cnt.add(vo.getPc_count());
            p_name.add(vo.getPi_name());
            
        }
        resultMap.put("prod_cnt", prod_cnt);
        resultMap.put("p_name", p_name);
        resultMap.put("allCnt",list.size());
        resultMap.put("status", true);
        

        return resultMap;

    }

  
 
}