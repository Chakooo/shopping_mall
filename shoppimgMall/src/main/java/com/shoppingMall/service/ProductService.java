package com.shoppingMall.service;

import java.text.DecimalFormat;
import java.util.List;

import com.shoppingMall.mapper.ProductMapper;
import com.shoppingMall.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductMapper mapper;

    public ProductInfoVO selectProductBySeq(Integer seq) {
        ProductInfoVO item = mapper.selectProductBySeq(seq);
        int i = item.getPi_si_seq();
        String si_name = mapper.getSellerName(i);
        item.setSeller_name(si_name);

        int discount_rate = item.getPi_discount_rate();
        int discounted = (int) (item.getPi_price() - (item.getPi_price() * discount_rate / 100.0));
        DecimalFormat formatter = new DecimalFormat("#,##0");

        item.setDiscounted_price(formatter.format(discounted));
        item.setOrigin_price(formatter.format(item.getPi_price()));


        i= item.getPi_cate_seq();
        String cate_name =mapper.getCategoryName(i);
        item.setCategory_name(cate_name);

        
        return item;
    }

 

    public String getProductImageFileName(String uri) {
        return mapper.getProductImageFileName(uri);
    }

}
