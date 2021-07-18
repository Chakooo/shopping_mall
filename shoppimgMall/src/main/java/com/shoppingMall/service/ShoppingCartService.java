package com.shoppingMall.service;

import java.util.List;

import com.shoppingMall.mapper.ProductMapper;
import com.shoppingMall.mapper.ShoppingCartMapper;
import com.shoppingMall.vo.ProductInfoVO;
import com.shoppingMall.vo.ShoppingCartVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    ShoppingCartMapper mapper;
    @Autowired
    ProductMapper p_mapper;

    public void insertProduct(ShoppingCartVO vo) {
        Integer cnt = mapper.selectCartProductCnt(vo);
        if (cnt == 1) {
            mapper.updateCartProductCnt(vo);
        } else {
            mapper.insertProduct(vo);
        }

    }

    public Integer selectCount(Integer mi_seq) {

        return mapper.selectCount(mi_seq);
    }

    public List<ProductInfoVO> selectCartProducts(Integer mi_seq) {
        List<ProductInfoVO> list = mapper.selectCartProducts(mi_seq);
        for (ProductInfoVO item : list) {
            int i = item.getPi_si_seq();
            String si_name = p_mapper.getSellerName(i);
            item.setSeller_name(si_name);
            // 리스트를 가져오는데, 이름값을 가져오는 mapper를 추가해준후에
            // vo변수(seller_name)를 set으로 재가공후에 리스트를 jsp에 던져준다.
            
            
            Integer rate =item.getPi_discount_rate();
            Integer price = item.getPi_price();
            Integer discounted = price - (price * rate) / 100; 
            // 할인률
            item.setDiscounted_price(discounted.toString());
            
        }
        return list;
    }
    
    public void deleteCartProduct(Integer pi_seq,Integer mi_seq){
        mapper.deleteCartProduct(pi_seq, mi_seq);
    }
    public void increaseProductCnt(Integer pi_seq,Integer mi_seq){
        mapper.increaseProductCnt(pi_seq, mi_seq);
    }
    public void decreaseProductCnt(Integer pi_seq,Integer mi_seq){
        mapper.decreaseProductCnt(pi_seq, mi_seq);
    }
    public void changeProductCnt (Integer pi_seq,Integer mi_seq,Integer cnt){
        mapper.changeProductCnt(pi_seq, mi_seq, cnt);
    }
}
