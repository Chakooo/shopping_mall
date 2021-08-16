package com.shoppingMall.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Payment {

     // 카카오페이
     @RequestMapping("/kakaopay")
     @ResponseBody
     public Map<String,Object> kakaopayment(
                        @RequestParam String pay,
                        @RequestParam String item,      
                        @RequestParam String seq                
     ){
         Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
         try {
            //  URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
            //  HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //  conn.setRequestMethod("POST");
            //  conn.setRequestProperty("Authorization", "KakaoAK df3ddcafb211450511481bfabbabbea1");
            //  conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            //  conn.setDoOutput(true);
 
            // String cid = "cid=TC0ONETIME&partner_order_id=partner_order_id";
            // String id = "&partner_user_id=partner_user_id";
 
            // item  = URLEncoder.encode(item , "UTF-8");// 한글깨짐 인코딩
            // String name = "&item_name="+item;
            
            // String quantity = "&quantity=1&total_amount="+pay; 
            // String amount = "&vat_amount=0&tax_free_amount=0";

            // String approval = "&approval_url=http://localhost:8070/member/myPage/"+seq;
            // String fail = "&fail_url=http://localhost:8070";           
            // String cancel = "&cancel_url=http://localhost:8070"; 
 
            // String param = cid+id+name+quantity+amount+approval+fail+cancel;
            
            // System.out.println(param);
             
            //  OutputStream output = conn.getOutputStream();
            //  DataOutputStream data = new DataOutputStream(output);
            //  data.writeBytes(param);
            //  data.close();
 
            //  int result = conn.getResponseCode();
 
            //  InputStream input ;
            //  if(result == 200){
            //      input = conn.getInputStream();
            //      System.out.println("코드확인1" + input);                
            //  }
            //  else{
            //      input = conn.getErrorStream();
            //      System.out.println("코드확인2" + input);
            //  }
            //  InputStreamReader reader = new InputStreamReader(input);
            //  BufferedReader bReader = new BufferedReader(reader);
            //  System.out.println(bReader.readLine());
            //  resultMap.put("data",bReader.readLine()); 
            //  System.out.println("확인리더 " +  bReader.readLine());
            //  return resultMap;

            URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "KakaoAK df3ddcafb211450511481bfabbabbea1");
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            conn.setDoOutput(true);

            String cid = "cid=TC0ONETIME&partner_order_id=partner_order_id";
            String id = "&partner_user_id=partner_user_id";
            item  = URLEncoder.encode(item , "UTF-8");// 한글깨짐 인코딩
            pay  = URLEncoder.encode(pay , "UTF-8");// 한글깨짐 인코딩
            String name = "&item_name="+item;
            String quantity = "&quantity=1&total_amount="+pay;           
            String amount = "&vat_amount=200&tax_free_amount=0";
            String approval = "&approval_url=http://localhost:8070/member/myPage/"+seq;
            String fail = "&fail_url=http://localhost:8070";
            String cancel = "&cancel_url=http://localhost:8070";

            String param = cid+id+name+quantity+amount+approval+fail+cancel;
            System.out.println(param);
            
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
            resultMap.put("data", bReader.readLine());
            return  resultMap;
            
            
         } catch (Exception e) {
             e.printStackTrace();
         }
 
         return resultMap;
     }
    
}
