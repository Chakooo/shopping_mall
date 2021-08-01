package com.shoppingMall.service;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.shoppingMall.mapper.ProductMapper;
import com.shoppingMall.vo.ProductImageVO;
import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductMapper mapper;

    public Map<String, Object> insertProduct(ProductVO vo) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if (vo.getPi_name() == "" || vo.getPi_name() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "제품명이 입력되지 않았습니다.");
            return resultMap;
        }
        if (vo.getPi_cate_seq() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "카테고리가 설정되지 않았습니다.");
            return resultMap;
        }
        if (vo.getPi_di_seq() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "배송업체가 설정되지 않았습니다.");
            return resultMap;
        }
        if (vo.getPi_price() == null) {
            resultMap.put("status", "failed");
            resultMap.put("message", "제품가격이 설정되지 않았습니다.");
            return resultMap;
        }
        if (vo.getPi_stock() == null) {
            vo.setPi_stock(0);
        }
        if (vo.getPi_discount_rate() == null) {
            vo.setPi_discount_rate(0);
        }
        if (vo.getPi_weight() == null) {
            vo.setPi_weight(0);
        }
        if (vo.getPi_point_rate() == null) {
            vo.setPi_stock(0);
        }
        mapper.insertProduct(vo);
        resultMap.put("status", "success");
        resultMap.put("message", "상품이 추가되었습니다.");
        return resultMap;
    }

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

        i = item.getPi_cate_seq();
        String cate_name = mapper.getCategoryName(i);
        item.setCategory_name(cate_name);

        return item;
    }

    public void insertProductImage(ProductImageVO vo) {
        mapper.insertProductImage(vo);
    }

    public String getProductImageFileName(String uri) {
        return mapper.getProductImageFileName(uri);
    }

    public List<ProductInfoVO> selectProducts(Integer offset, String keyword, Integer category, Integer si_seq) {
        
        if (offset == null)
            offset = 0;
        if (keyword == null) {
            keyword = "%%";
        } else {
            keyword = "%" + keyword + "%";
        }
        
        List<ProductInfoVO> list = mapper.selectProducts(offset,keyword,category,si_seq);
        System.out.println(list);
        System.out.println("서비스 인");
        return list;

    }

    public List<ProductInfoVO> selectProductsByCategory(Integer cate_seq) {

        List<ProductInfoVO> list = mapper.selectProductsByCategory(cate_seq);
        for (ProductInfoVO item : list) {
            int i = item.getPi_si_seq();
            String si_name = mapper.getSellerName(i);
            item.setSeller_name(si_name);
            // 리스트를 가져오는데, 이름값을 가져오는 mapper를 추가해준후에
            // vo변수(seller_name)를 set으로 재가공후에 리스트를 jsp에 던져준다.

            int discount_rate = item.getPi_discount_rate();
            int discounted = (int) (item.getPi_price() - (item.getPi_price() * discount_rate / 100.0));
            DecimalFormat formatter = new DecimalFormat("#,##0");
            // 1000단위 마다 콤마찍어준다.
            item.setDiscounted_price(formatter.format(discounted));
            item.setOrigin_price(formatter.format(item.getPi_price()));
        }
        return list;
    }

    public void deleteProduct(Integer seq) {
        mapper.deleteProduct(seq);
    }

    public ProductVO productBySeq(Integer seq) {// 수정할때 하나의 정보가져와서 보여주는 용도
        return mapper.productBySeq(seq);
    }

    public void updateProduct(ProductVO vo) {
        mapper.updateProduct(vo);
    }

    public void insertSellerRegistImage(Integer si_seq, String imageUri ,String saveFileName){
        mapper.insertSellerRegistImage(si_seq,imageUri,saveFileName);

    }

}
