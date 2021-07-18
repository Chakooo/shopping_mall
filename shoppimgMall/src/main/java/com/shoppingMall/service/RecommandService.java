package com.shoppingMall.service;

import java.text.DecimalFormat;
import java.util.List;

import com.shoppingMall.mapper.ProductMapper;
import com.shoppingMall.mapper.RecommandMapper;
import com.shoppingMall.vo.ProductInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommandService {
    @Autowired RecommandMapper r_mapper;
    @Autowired ProductMapper p_mapper;

    public List<ProductInfoVO> selectRecommandProducts() {
        List<ProductInfoVO> list = r_mapper.selectRecommandProducts();
        for (ProductInfoVO item : list) {
            int i = item.getPi_si_seq();
            String si_name = p_mapper.getSellerName(i);
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
}
