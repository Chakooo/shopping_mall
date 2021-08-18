package com.shoppingMall.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.shoppingMall.mapper.MemberMapper;
import com.shoppingMall.utils.AESAlgorithm;
import com.shoppingMall.vo.LoginVO;
import com.shoppingMall.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberMapper mapper;
    public Map<String,Object> insertMember(MemberInfoVO vo){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        boolean duplicated = isDuplicatedId(vo.getMi_id());
        if(duplicated){
            resultMap.put("status", false);
            resultMap.put("message","아이디가 중복됩니다.");
            return resultMap;
        }// 넣기전에 아이디를 한번더 비교한다.

        boolean email_dup = isDuplicatedEmail(vo.getMi_email());
        if(email_dup){
            resultMap.put("status", false);
            resultMap.put("message","이메일이 중복됩니다.");
            return resultMap;
        }

        String pwd =vo.getMi_pwd(); //입력된 비밀번호를 가져와서 암화화해서 DB에 저장

        try {
            pwd =AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }      
        vo.setMi_pwd(pwd);

        System.out.println("memberjoin service 들어옴");
        System.out.println(pwd);
        mapper.insertMember(vo);

        resultMap.put(("status"), true);
        resultMap.put(("message"),"회원가입이 완료 됐습니다.");        

        return resultMap;
    }
    public boolean isDuplicatedId(String id){

        
    return mapper.selectMemberById(id) > 0 ;
    }
    public boolean isDuplicatedEmail(String email){
        
    return mapper.selectMemberByEmail(email) > 0 ;
    }
    public List<MemberInfoVO> selectMemberAll(){

        return mapper.selectMemberAll();
    }
    public void deleteMember(Integer seq){

         mapper.deleteMember(seq);
    }

    public Map<String,Object> loginMember(LoginVO vo){ 
    // 로그인 성공시 boolean 값으로 보내는게 아니라 성공한유저의 정보를 같이 담아서 api로 옮기기위해 map을 사용한다.
        Map<String,Object> resultMap =new LinkedHashMap<String,Object>();
        String pwd =vo.getPwd();
        try {
            pwd =AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        vo.setPwd(pwd);
        Integer result =mapper.loginMember(vo);
        if(result==1){
            resultMap.put("status",true);
            MemberInfoVO member =mapper.selectMemberInfo(vo.getId());
            resultMap.put("member", member);
        }
        else{
            resultMap.put("status", false);
            resultMap.put("message", "아이디 혹은 비밀번호 오류입니다.");
        }
        
        return resultMap;
    }
    public Integer pwdCheck(String pwd, Integer seq){
        String pwd2 ="";
        try {
            pwd2= AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pwd = pwd2;        
        Integer result =  mapper.pwdCheck(pwd, seq);
        return result;
    }


    public Map<String,Object> memberModify(MemberInfoVO vo){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();       

      

        String pwd =vo.getMi_pwd(); //입력된 비밀번호를 가져와서 암화화해서 DB에 저장

        try {
            pwd =AESAlgorithm.Encrypt(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }      
        vo.setMi_pwd(pwd);

        
        mapper.memberModify(vo);
        resultMap.put("status",true);
        MemberInfoVO member =mapper.selectMemberInfo(vo.getMi_id());
        resultMap.put("member", member);   
        

        
        resultMap.put(("status"), true);
        resultMap.put(("message"),"수정 됐습니다.");        

        return resultMap;
    }
}
