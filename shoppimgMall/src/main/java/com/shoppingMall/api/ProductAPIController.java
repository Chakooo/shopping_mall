package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.service.ProductService;
import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPIController {
    @Autowired
    ProductService service;
    
    @GetMapping("/product/api/list")
    public Map<String, Object> getProductList(@RequestParam @Nullable String keyword,
            @RequestParam @Nullable Integer offset, @RequestParam @Nullable Integer category, @RequestParam Integer si_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductInfoVO> list = service.selectProducts(offset,keyword,category,si_seq);
        resultMap.put("data", list);
        return resultMap;
    }
    @PostMapping("/product/api/add")
    public Map<String, Object> getProduct(@RequestBody ProductVO vo) {

        return service.insertProduct(vo);
    }
    @DeleteMapping("/product/api/delete")
    public Map<String, Object> deleteProduct(@RequestParam Integer seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteProduct(seq);
        resultMap.put("message", "삭제됐습니다.");
        return resultMap;
    }

    @PatchMapping("/product/api/update")
    public Map<String,Object> postProductUpdateAPI(@RequestBody ProductVO vo){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.updateProduct(vo);
        resultMap.put("status",true);
        resultMap.put("message", "수정되었습니다.");

        return resultMap;

    }
    @GetMapping("/product/api/get")
    public Map<String,Object> getProduct(@RequestParam Integer seq){
     Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

     ProductVO vo = service.productBySeq(seq);
     resultMap.put("status",true);
     resultMap.put("data",vo);

     return resultMap;
    }
    
}
