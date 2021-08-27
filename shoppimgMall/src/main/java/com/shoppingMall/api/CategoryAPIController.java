package com.shoppingMall.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.service.CategoryService;
import com.shoppingMall.vo.CategoryVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryAPIController {
    @Autowired CategoryService service;
    
    @GetMapping("/category/api/add")
    public Map<String,Object> cateApiAdd(@RequestParam String name){ 
    Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
    boolean r = service.addCategory(name);
    if(r){
        resultMap.put("status",r);
        resultMap.put("message", "["+name+"] 카테고리를 추가했습니다.");  
    }
    else{
        resultMap.put("status",r);
        resultMap.put("message", "["+name+"] 카테고리는 이미 존재합니다.")  ;      
    }    
    return resultMap;
    }
    
    @GetMapping("/category/api/list")
    public Map<String,Object> getCategoryList (){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        List<CategoryVO> list = service.selectCategoryAll();
        resultMap.put("data", list);

        
        return resultMap;
    }

    @DeleteMapping("/category/api/delete")
    public Map<String,Object> deleteCategory(@RequestParam Integer seq){
        Map<String,Object> resultMap = new LinkedHashMap<String,Object>();
        service.deleteCategory(seq);
        resultMap.put("message", "삭제됐습니다.");
        return resultMap;
        
    }
    
}
