package com.shoppingMall.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import com.shoppingMall.service.MemberService;
import com.shoppingMall.vo.MemberInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
    @Autowired MemberService service;


    @GetMapping("/login")
    public String getLogin(){
        return "/member/login";
    }
    @GetMapping("/join")
    public String getJoin(){

        return "/member/join";
    }
    @GetMapping("/member/logout")
    public String getLogout(HttpSession session){
        session.invalidate();//invalidate << 무효화.
        return "redirect:/";
    }
    @GetMapping("/member/list")
    public String getMemberList(Model model){
        List<MemberInfoVO> resultList= service.selectMemberAll();
        model.addAttribute("list", resultList);
        return "/admin/list";
    }
    @GetMapping("/member/myPage/{seq}")
    public String getMemberPage(@PathVariable Integer seq){

        return "/member/myPage";
    }

    @Autowired
    JavaMailSender javaMailSender;
   


// 이메일 인증구현


@PostMapping("/sendEmail") // AJAX와 URL을 매핑시켜줌 
@ResponseBody  //AJAX후 값을 리턴하기위해 작성

    public String SendMail(String mi_email) {
		Random random=new Random();  //난수 생성을 위한 랜덤 클래스
		String key="";  //인증번호 

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("alexpark0926@gmail.com"); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
		//입력 키를 위한 코드
		for(int i =0; i<3;i++) {
			int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
			key+=(char)index;
		}
		int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
		key+=numIndex;
        System.out.println(key);
		message.setSubject("인증번호 입력을 위한 메일 전송");
		message.setText("인증 번호 : "+key);
		javaMailSender.send(message);
        return key;
	}


  

}
