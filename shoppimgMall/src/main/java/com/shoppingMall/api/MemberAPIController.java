package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.shoppingMall.service.MemberService;
import com.shoppingMall.service.ShoppingCartService;
import com.shoppingMall.vo.LoginVO;
import com.shoppingMall.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberAPIController {

    @Autowired
    MemberService service;
    @Autowired
    ShoppingCartService sc_service;

    @PostMapping("/member/join")
    public Map<String, Object> postMemberJoin(@RequestBody MemberInfoVO vo) {
        return service.insertMember(vo);

    }

    @GetMapping("/member/id_check")
    public Map<String, Object> getIdCheck(@RequestParam String id) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if (service.isDuplicatedId(id)) {
            resultMap.put("status", false);
            resultMap.put("message", "[" + id + "]는 이미 사용중입니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("message", "[" + id + "]는 사용하실 수 있습니다.");
        return resultMap;
    }

    @GetMapping("/member/email_check")
    public Map<String, Object> getEmailCheck(@RequestParam String email) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if (service.isDuplicatedEmail(email) == true) {
            resultMap.put("status", false);
            resultMap.put("message", "[" + email + "]는 이미 사용중입니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("message", "[" + email + "]는 사용하실 수 있습니다.");
        return resultMap;
    }

    @DeleteMapping("/member/delete")
    public Map<String, Object> deleteMember(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.deleteMember(seq);
        resultMap.put("status", true);
        resultMap.put("message", "삭제완료");
        return resultMap;
    }
    @PostMapping("/member/login")
    public Map<String,Object> postMemberLogin(@RequestBody LoginVO vo , HttpSession session){
        Map<String, Object> resultMap =  service.loginMember(vo);
        session.setAttribute("member",resultMap.get("member"));
        //resulmap 에 담김 member를 기본형태가 object타입이기때매 멤버인포vo형태로 형변환해서 멤버변수에 접근가능.
        // System.out.println(resultMap.get("member"));
        MemberInfoVO member = (MemberInfoVO)resultMap.get("member");

        
        if(member!=null){ 
        Integer cart_cnt = sc_service.selectCount(member.getMi_seq());
        session.setAttribute("cart_cnt", cart_cnt);      
        
    } 
        return resultMap;
    }
    @PostMapping("/member/pwdCheck")
    public Map<String,Object> postMemberLogin(@RequestBody MemberInfoVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String,Object>();
        Integer result = service.pwdCheck(vo.getMi_pwd(), vo.getMi_seq());
        
        if(result == 1){
            resultMap.put("status",true);
            return resultMap;
        }        
        else{
            resultMap.put("status",false);
            resultMap.put("message","비밀번호를 확인해주세요.");
            return resultMap;
        }   
    }
    @PatchMapping("/member/modMemberInfo")
    public Map<String,Object> modifyMemberInfo(@RequestBody MemberInfoVO vo,HttpSession session){
        Map<String,Object> resultMap = service.memberModify(vo);

        session.setAttribute("member",resultMap.get("member"));
       
        return resultMap;
    }
}
