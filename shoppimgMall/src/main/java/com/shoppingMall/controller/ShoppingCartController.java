package com.shoppingMall.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.shoppingMall.service.ShoppingCartService;
import com.shoppingMall.vo.KakaoPayVO;
import com.shoppingMall.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingCartController {
    @Autowired ShoppingCartService service;

    @GetMapping("/cart")
    public String getShoppingCart(){return "redirect:/login";}



    // http://localhost/cart/아이디?dqxSrEp=123
    @GetMapping("/cart/{member_id}")
    public String getShoppingCart(@PathVariable @Nullable String member_id , @RequestParam @Nullable Integer  dqxSrEp , Model model){
    // dqxSrEp = 사용자의 db상의 mi_seq 번호
        if(member_id==null || dqxSrEp==null || member_id==""||dqxSrEp==0){          
            return "redirect:/login";
        }
        List<ProductInfoVO> list= service.selectCartProducts(dqxSrEp);
        model.addAttribute("list",list);
        return "/product/cart";
    }



    // 카카오페이
    @RequestMapping("/kakaopay")
    @ResponseBody
    public String kakaopay(@RequestParam String pay,
                        @RequestParam String item  
    
    
    
    
    ){
        try {
            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "KakaoAK df3ddcafb211450511481bfabbabbea1");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            conn.setDoOutput(true);

           String cid = "cid=TC0ONETIME&partner_order_id=partner_order_id";
           String id = "&partner_user_id=partner_user_id";
           item  = URLEncoder.encode(item , "UTF-8");// 한글깨짐 인코딩
           String name = "&item_name="+item;
           String quantity = "&quantity=1&total_amount="+pay;
           String amount = "&vat_amount=200&tax_free_amount=0";
           String approval = "&approval_url=http://localhost:8070";
           String fail = "&fail_url=http://localhost:8070";
           String cancel = "&cancel_url=http://localhost:8070";

           String param = cid+id+name+quantity+amount+approval+fail+cancel;
            
            OutputStream output = conn.getOutputStream();
            DataOutputStream data = new DataOutputStream(output);
            data.writeBytes(param);
            data.close();

            int result = conn.getResponseCode();

            InputStream input ;
            if(result == 200){
                input = conn.getInputStream();
            }
            else{
                input = conn.getErrorStream();
            }
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bReader = new BufferedReader(reader);

            return bReader.readLine(); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "NO";
    }


}