package com.shoppingMall.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.shoppingMall.mapper.ReviewMapper;
import com.shoppingMall.service.MemberService;
import com.shoppingMall.service.OrderService;
import com.shoppingMall.service.ReviewService;
import com.shoppingMall.vo.MemberInfoVO;
import com.shoppingMall.vo.OrderProductVO;
import com.shoppingMall.vo.ReviewVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MemberController {
    @Autowired
    MemberService service;
    @Autowired
    OrderService order_service;
    @Autowired
    ReviewMapper review_mapper;
    @Autowired
    ReviewService r_service;

    @GetMapping("/login")
    public String getLogin() {
        return "/member/login";
    }

    @GetMapping("/join")
    public String getJoin() {

        return "/member/join";
    }

    @GetMapping("/member/logout")
    public String getLogout(HttpSession session) {
        session.invalidate();// invalidate << 무효화.
        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String getMemberList(Model model) {
        List<MemberInfoVO> resultList = service.selectMemberAll();
        model.addAttribute("list", resultList);
        return "/admin/list";
    }

    @GetMapping("/member/myPage/{seq}")
    public String getMemberPage(@PathVariable Integer seq,Model model,HttpSession session) {

        MemberInfoVO member = (MemberInfoVO)session.getAttribute("member");
        if(member ==null){
            return "redirect:/login";
        }
        
        Integer mi_seq = member.getMi_seq();
        List<OrderProductVO> list =order_service.selectOrderInfo(mi_seq);
        model.addAttribute("order_list",list);

        
        List<ReviewVO> r_list = review_mapper.selectReviewByMember(mi_seq);

          // 판매자의 답변이 달려있는지의 여부를 확인한다.

        for(int i=0; i<r_list.size();i++){
        Boolean answer = review_mapper.getReviewAnswerCnt(r_list.get(i).getRev_seq())==1;

        list.get(i).setReview_answer(answer);
        System.out.println("i값 다 찍기 :"+r_list.get(i).getRev_seq() +","+answer);
     
    }
        model.addAttribute("r_list",r_list);
        return "/member/myPage";
    }

    @Autowired
    JavaMailSender javaMailSender;

    // 이메일 인증구현

    @PostMapping("/sendEmail") // AJAX와 URL을 매핑시켜줌  
    public String SendMail(@RequestParam String mail) {
        Random random = new Random(); // 난수 생성을 위한 랜덤 클래스
        String key = ""; // 인증번호

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail); // 스크립트에서 보낸 메일을 받을 사용자 이메일 주소
        // 입력 키를 위한 코드
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(25) + 65; // A~Z까지 랜덤 알파벳 생성
            key += (char) index;
        }
        int numIndex = random.nextInt(9999) + 1000; // 4자리 랜덤 정수를 생성
        key += numIndex;
        System.out.println(key);
        message.setSubject("인증번호 입력을 위한 메일 전송");
        message.setText("인증 번호 : " + key);
        javaMailSender.send(message);
        return key;
    }
    @GetMapping("/member/modify")
    public String memberModify(){


        return "/member/modify";
    }
    @GetMapping("/member/review_answer/{seq}")
    public String getReviewAnswer(@PathVariable Integer seq,Model model){

        List<ReviewVO> r_list = r_service.selectReviewByMember(seq);
        model.addAttribute("r_list", r_list);
        for(int i=0; i<r_list.size();i++){
            Boolean answer = review_mapper.getReviewAnswerCnt(r_list.get(i).getRev_seq())==1;    
            r_list.get(i).setReview_answer(answer);         
        }

        return "/member/review_answer";
    }

}
