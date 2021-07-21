package com.shoppingMall.service;

import java.util.List;

import com.shoppingMall.mapper.DeliveryMapper;
import com.shoppingMall.vo.DeliveryInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired DeliveryMapper mapper;
    public boolean addDelivery(DeliveryInfoVO vo){
        Integer cnt = mapper.selectDeliveryByName(vo.getDi_name());
        if(cnt!=0){

            return false;
        }
        mapper.insertDeliveryInfo(vo);
        return true;
    }
    public boolean isExistDelivery(String name){
        Integer cnt = mapper.selectDeliveryByName(name);
        if(cnt!=0){
            return true; //배송사가 존재한다  1일떄
        }
        return false; //배송사가 존재하지 않는다. 0일떄
    }


    public List<DeliveryInfoVO> selectDeliveryAll(){   
        List<DeliveryInfoVO> list = mapper.selectDeliveryAll();
        for(int i=0; i<list.size();i++){
            Integer cnt = mapper.selectDeliveryProdCnt(list.get(i).getDi_seq());
            list.get(i).setDelivery_prod_cnt(cnt);
        }
        return  list;
    }
    public void deleteDelivery(Integer seq){
        mapper.deleteDelivery(seq);
    }

}
