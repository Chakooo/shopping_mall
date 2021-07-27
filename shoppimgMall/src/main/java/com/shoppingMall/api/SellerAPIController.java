package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.shoppingMall.service.SellerService;
import com.shoppingMall.vo.LoginVO;
import com.shoppingMall.vo.ReviewVO;
import com.shoppingMall.vo.SellerInfoVO;
import org.springframework.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerAPIController {
    @Autowired
    SellerService s_service;

    @PostMapping("/seller/regist")
    public Map<String, Object> postSellerRegist(@RequestBody SellerInfoVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Boolean r = s_service.insertSeller(vo);
        if (r) {
            resultMap.put("result", "success");
            resultMap.put("message", "회원가입 성공");
        } else {
            resultMap.put("result", "fail");
            resultMap.put("message", "회원가입 실패");
        }

        return resultMap;
    }

    @GetMapping("/seller/isDuplicateId")
    public Map<String, Object> getIsDuplicateId(@RequestParam String id) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if (s_service.isDuplicateId(id)) {
            resultMap.put("status", true);
            resultMap.put("message", "아이디가 중복됩니다.");
        } else {
            resultMap.put("status", false);
            resultMap.put("message", "가입가능한 아이디입니다.");
        }
        return resultMap;
    }

    @GetMapping("/seller/email_check")
    public Map<String, Object> getEmailCheck(@RequestParam String email) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if (s_service.isDuplicatedEmail(email) == true) {
            resultMap.put("status", false);
            resultMap.put("message", "[" + email + "]는 이미 사용중입니다.");
            return resultMap;
        }
        resultMap.put("status", true);
        resultMap.put("message", "[" + email + "]는 사용하실 수 있습니다.");
        return resultMap;
    }

    @PostMapping("/seller/login")
    public Map<String, Object> getSellerLogin(@RequestBody LoginVO vo, HttpSession session) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap = s_service.loginSeller(vo);
        SellerInfoVO seller = (SellerInfoVO) resultMap.get("seller");
        session.setAttribute("seller", seller);
        return resultMap;
    }

    @GetMapping("/seller/showChart")
    public Map<String, Object> getSellerChart(@RequestParam Integer si_seq) {
        Map<String, Object> resultMap = s_service.showProdCnt(si_seq);

        return resultMap;
    }

    @GetMapping("/seller/showChartYesterDay")
    public Map<String, Object> getSellerChartYesterDay(@RequestParam Integer si_seq) {
        Map<String, Object> resultMap = s_service.showProdCntYesterDay(si_seq);

        return resultMap;
    }

    @GetMapping("/seller/showChartByDate")
    public Map<String, Object> getSellerChartDate(@RequestParam Integer si_seq, @RequestParam @Nullable String date) {
        Map<String, Object> resultMap = s_service.showProdCntByDate(si_seq, date);

        return resultMap;
    }

    @GetMapping("/seller/showProdCntByTerm")
    public Map<String, Object> getSellerChartTerm(@RequestParam Integer si_seq , @RequestParam @Nullable String term) {
        Map<String, Object> resultMap = s_service.showProdCntByTerm(si_seq,term);
        return resultMap;
    }
    @GetMapping("/seller/showProdCntByTermDate")
    public Map<String, Object> getSellerChartByTermDate(@RequestParam Integer si_seq , @RequestParam @Nullable String start_date,
    @RequestParam @Nullable String end_date) {
        Map<String, Object> resultMap = s_service.showProdCntByTermDate(si_seq,start_date,end_date);
        return resultMap;
    }  

    @GetMapping("/seller/showChartRank")
    public Map<String, Object> getSellerChartRank(@RequestParam Integer si_seq) {
        Map<String, Object> resultMap = s_service.showProdCntRank(si_seq);

        return resultMap;
    }

    @GetMapping("/seller/showReiview")
    public Map<String, Object> showReiview(@RequestParam Integer si_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ReviewVO> list =   s_service.showReiview(si_seq);
        resultMap.put("list",list);
        return resultMap;
    }
}
