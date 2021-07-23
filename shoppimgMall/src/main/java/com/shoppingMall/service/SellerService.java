package com.shoppingMall.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.mapper.SellerMapper;
import com.shoppingMall.utils.AESAlgorithm;
import com.shoppingMall.vo.LoginVO;
import com.shoppingMall.vo.SellerInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerMapper mapper;

    public boolean insertSeller(SellerInfoVO vo) {

        Integer cntId = mapper.selectSellerById(vo.getSi_id()); // 아이디 중복 검사 먼저 실행
        Integer cntEmail= mapper.selectSellerByEmail(vo.getSi_email());

        if (cntId != 0) {
            return false;
        }
        if(cntEmail != 0){
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
            pwd =AESAlgorithm.Encrypt(pwd);
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

    public boolean isDuplicatedEmail(String email){
        
        return mapper.selectSellerByEmail(email) > 0 ;
        }

    public Map<String,Object> loginSeller(LoginVO vo){
        Map<String,Object> resultMap =new LinkedHashMap<String,Object>();
        String pwd = vo.getPwd();
        try {
            pwd = AESAlgorithm.Encrypt(pwd);    
        } catch (Exception e) {
            e.printStackTrace();
        }

        vo.setPwd(pwd);
        Integer result = mapper.loginSeller(vo);
        if(result ==1 ){
            resultMap.put("status", true);
            SellerInfoVO seller = mapper.selectSellerInfoById(vo.getId());
            resultMap.put("seller", seller);
        }else{
            resultMap.put("status",false);
            resultMap.put("message", "아이디 또는 비밀번호가 틀렸습니다.");
        }
        return resultMap;
    }
        public List<SellerInfoVO> selectSellerAll(){
            List<SellerInfoVO> list = mapper.selectSellerAll();
            // for(int i=0; i<list.size();i++){
            //     Integer cnt = mapper.selectSellerProdCnt(list.get(i).getSi_seq());
            //     list.get(i).setSeller_prod_cnt(cnt);
            // }
            return  list;
        }
    }