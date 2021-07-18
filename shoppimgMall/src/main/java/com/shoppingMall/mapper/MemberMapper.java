package com.shoppingMall.mapper;

import java.util.List;

import com.shoppingMall.vo.LoginVO;
import com.shoppingMall.vo.MemberInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberInfoVO vo);
    public Integer selectMemberById(String id);
    public Integer selectMemberByEmail(String email);
    public List<MemberInfoVO> selectMemberAll();
    public void deleteMember(Integer seq);


    //로그인
    public Integer loginMember(LoginVO vo);
    //로그인시 멤버의 정보까지 같이가져가주기위해서 매퍼작성
    public MemberInfoVO selectMemberInfo(String id);
    
}
