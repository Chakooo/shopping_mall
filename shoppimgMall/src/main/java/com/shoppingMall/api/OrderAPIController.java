package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.Map;

import com.shoppingMall.service.OrderService;
import com.shoppingMall.vo.OrderInfoVO;
import com.shoppingMall.vo.ProductCountVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//  Map 과 HashMap 구조이해하기

@RestController
public class OrderAPIController {
    @Autowired
    OrderService service;

    @PostMapping("/order")
    public Map<String, Object> postOrderAdd(@RequestBody OrderInfoVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.insertOrderInfo(vo);
        resultMap.put("status", true);
        resultMap.put("message", "주문완료");
        return resultMap;
    }

    @DeleteMapping("/order/delete")
    public Map<String, Object> deleteOrder(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteOrderInfo(seq);
        resultMap.put("status", true);
        return resultMap;
    }

    // @PatchMapping("/order/status")
    // public Map<String,Object> patchOrder(@RequestParam Integer seq ,
    // @RequestParam Integer status){
    // Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
    // service.updateOrderStatus(seq,status);
    // resultMap.put("status",true);
    // return resultMap;
    // }
    @PatchMapping("/order/status")
    public Map<String, Object> pathchOrderStatus(@RequestParam Integer status, @RequestParam Integer oi_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

        service.UpdateDeliveryStatus(status, oi_seq);
        resultMap.put("status", true);
        return resultMap;
    }

    @PatchMapping("/order/status/delivery")
    public Map<String, Object> patchOrderDelivery(@RequestParam Integer seq, @RequestParam Integer status) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.updateOrderDeliveryStatus(seq, status);
        resultMap.put("status", true);
        return resultMap;
    }

    @PostMapping("/order/product/count")
    public Map<String, Object> addProductCount(@RequestBody ProductCountVO vo) {
        System.out.println("테스트합니다");
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.insertProductConunt(vo);
        resultMap.put("status",true);
        resultMap.put("message","물품 count 추가 성공");
        return resultMap;
    }
}
