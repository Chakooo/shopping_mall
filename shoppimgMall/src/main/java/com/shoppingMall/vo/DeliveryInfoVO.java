package com.shoppingMall.vo;

import lombok.Data;

@Data
public class DeliveryInfoVO {
    private Integer di_seq;
    private String di_name;
    private String di_phone;
    private Integer di_price;
    private Integer delivery_prod_cnt;
}
