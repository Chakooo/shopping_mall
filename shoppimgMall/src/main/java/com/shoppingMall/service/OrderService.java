package com.shoppingMall.service;

import java.text.DecimalFormat;
import java.util.List;

import com.shoppingMall.mapper.OrderMapper;
import com.shoppingMall.mapper.ReviewMapper;
import com.shoppingMall.vo.OrderInfoVO;
import com.shoppingMall.vo.OrderProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderMapper mapper;
    @Autowired
    ReviewMapper r_mapper;
    public List<OrderProductVO> selectOrderInfo(Integer mi_seq) {
        List<OrderProductVO> list = mapper.selectOrderInfo(mi_seq);

        DecimalFormat formatter = new DecimalFormat("###,###"); // 천자리마다 쉼표찍는다.
        for (OrderProductVO item : list) {
            // 1.값 가져오기
            Integer discount_rate = item.getPi_discount_rate();
            Integer point_rate = item.getPi_point_rate();
            Integer origin_price = item.getPi_price();
            Integer count = item.getOi_prod_count();
            // 2.할인금액과 적립금액 계산
            Integer final_price = (int) (origin_price - origin_price * discount_rate / 100.0) * count;
            Integer final_point = (int) (final_price * point_rate / 100.0);
            // 3. 1000단위마다 쉼표 표시하는 형식
            String formatter_final_price = formatter.format(final_price);
            String formatter_final_point = formatter.format(final_point);
            String formatter_origin_price = formatter.format(origin_price * count);

            // 4. 3까지 진행된값을 셋으로 객체에 저장
            item.setFinal_price(formatter_final_price);
            item.setFinal_point(formatter_final_point);
            item.setOrigin_price(formatter_origin_price);
            // 5. 리뷰 작성 여부를 확인한다.
            Integer oi_seq = item.getOi_seq();
            Boolean written = r_mapper.selectMemberProdReviewCnt(oi_seq) == 1; // true 나  false 를 반환한다.
            item.setReview_written(written);
        }
        return list;
    }

    public void insertOrderInfo(OrderInfoVO vo) {
        mapper.insertOrderInfo(vo);
    }

    public void deleteOrderInfo(Integer seq) {
        mapper.deleteOrderInfo(seq);
    }

    public void updateOrderStatus(Integer seq, Integer status) {
        mapper.updateOrderStatus(seq, status);
    }

    public void updateOrderDeliveryStatus(Integer seq, Integer status) {
        mapper.updateOrderDeliveryStatus(seq, status);
    }
    public List<OrderInfoVO> orderInfo(Integer offset,Integer seq){
        return mapper.orderInfo(offset,seq);
    }

    public Integer selectOrderCount(){
        return mapper.selectOrderCount();
    }
    public void UpdateDeliveryStatus(Integer status , Integer oi_seq){
        mapper.UpdateDeliveryStatus(status, oi_seq);
   }
}
