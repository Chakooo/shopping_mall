package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.service.DeliveryService;
import com.shoppingMall.vo.DeliveryInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryAPIController {
    @Autowired DeliveryService service;


    @PostMapping("/delivery/api/add")
    public Map<String,Object> postDeliveryApiAdd(@RequestBody DeliveryInfoVO vo){
        Map<String,Object> resultMap =new LinkedHashMap<String,Object>();
        System.out.println(vo);
        boolean b =service.addDelivery(vo);
        resultMap.put("status", b);
        if(b){
            resultMap.put("message", "배송업체 등록에 성공했습니다.");           
        }
        else{
            resultMap.put("message", "배송업체 등록에 실패했습니다.");           
        }

        // String msg = service.addDelivery(vo)?"배송업체 등록 성공":"배송업체 등록 실패";      3항연산자로도 가능
        // resultMap.put("status", b);
        // resultMap.put("message", msg);
        return resultMap;
    }
    @GetMapping("/delivery/api/check")
    public Map<String,Object> getDeliveryApiCheck(@RequestParam String name){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        boolean b = service.isExistDelivery(name);
        resultMap.put("status", b);
        if(b){
            resultMap.put("message","["+name+"]은 이미 존재합니다");
        }
        else{
            resultMap.put("message","["+name+"]은 등록 가능합니다");

        }

        return resultMap;
    }
    @GetMapping("/delivery/api/list")
    public  Map<String,Object> getDeliveryList(){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        List<DeliveryInfoVO> list= service.selectDeliveryAll();
        resultMap.put("data", list);
        return resultMap;
    }
    @DeleteMapping("/delivery/api/delete")
    public  Map<String,Object> deleteDelivery(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        service.deleteDelivery(seq);
        resultMap.put("message", "삭제됐습니다.");
        return resultMap;
    }    
    
}
