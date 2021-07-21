package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.service.ProductService;
import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<ProductInfoVO> list = service.selectProducts(si_seq);
        resultMap.put("data", list);
        return resultMap;
    }
    @PostMapping("/product/api/add")
    public Map<String, Object> getProduct(@RequestBody ProductVO vo) {

        return service.insertProduct(vo);
    }
    
}
