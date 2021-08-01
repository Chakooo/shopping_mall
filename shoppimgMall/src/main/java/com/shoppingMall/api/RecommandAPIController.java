package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.service.RecommandService;
import com.shoppingMall.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommandAPIController {
    @Autowired  RecommandService service;

    @GetMapping("/product/api/recommand")
    public Map<String, Object> selectSellerRecommandProducts(@RequestParam Integer si_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductVO> list = service.selectSellerRecommandProducts(si_seq);
        resultMap.put("status", true);
        resultMap.put("list", list);
        return resultMap;
    }
    @GetMapping("/product/api/not_recommand/{si_seq}")
    public Map<String, Object> getNotRecommandProdAPI(@PathVariable Integer si_seq,@RequestParam @Nullable String keyword) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductVO> list = service.selectSellerNotRecommandProducts(si_seq, keyword);
        resultMap.put("status", true);
        resultMap.put("list", list);

        return resultMap;
    }
    @PutMapping("/product/api/recommand")
    public Map<String, Object> putRecommandProdAPI(@RequestParam Integer prod_seq , @RequestParam Integer si_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.insertSellerRecommandProduct(prod_seq,si_seq);
        resultMap.put("status", true);
        resultMap.put("message", "추천상품이 추가되었습니다.");
        return resultMap;
    }
    @DeleteMapping("/product/api/recommand")
    public Map<String, Object> deleteSellerRecommandProduct(@RequestParam Integer prod_seq ,@RequestParam Integer si_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteSellerRecommandProduct(prod_seq,si_seq);
        resultMap.put("status", true);
        resultMap.put("message", "추천상품이 삭제되었습니다.");
        return resultMap;
    }

    // admin page 추천상품 //


    @GetMapping("/admin/api/not_recommand/{cate_seq}/{si_seq}")
    public Map<String, Object> getNotRecommandProdAPI(@PathVariable Integer cate_seq, @PathVariable Integer si_seq,
            @RequestParam @Nullable String keyword) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductVO> list = service.selectNotRecommandProducts(cate_seq, si_seq, keyword);
        resultMap.put("status", true);
        resultMap.put("list", list);

        return resultMap;
    }
    @PutMapping("/admin/put/recommand")
    public Map<String, Object> putRecommandProdAPI(@RequestParam Integer prod_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.insertRecommandProduct(prod_seq);
        resultMap.put("status", true);
        resultMap.put("message", "추천상품이 추가되었습니다.");
        return resultMap;
    }
    @GetMapping("/admin/list/recommand")
    public Map<String, Object> getRecommandProdAPI() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<ProductVO> list = service.showRecommandProducts();
        resultMap.put("status", true);
        resultMap.put("list", list);

        return resultMap;
    }
    @DeleteMapping("/admin/api/recommand")
    public Map<String, Object> deleteRecommandProdAPI(@RequestParam Integer prod_seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        service.deleteRecommandProduct(prod_seq);
        resultMap.put("status", true);
        resultMap.put("message", "추천상품이 삭제되었습니다.");
        return resultMap;
    }





    



    
    
}
