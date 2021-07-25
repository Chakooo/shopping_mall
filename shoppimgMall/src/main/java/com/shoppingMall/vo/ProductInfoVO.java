package com.shoppingMall.vo;


import lombok.Data;

@Data
public class ProductInfoVO {
    private Integer pi_seq;
    private String pi_name;
    private Integer pi_cate_seq;
    private Integer pi_stock;
    private Integer pi_si_seq;
    private String pi_create_dt;
    private Integer pi_discount_rate;
    private String pi_caution;
    private Integer pi_weight;
    private Integer pi_point_rate;
    private Integer pi_di_seq;
    private Integer pi_price;
    private String pi_img_uri;
    private String cate_name;
    private String di_name;

    // 판매자 이름을 가져오기위해 추가
    private String seller_name;

    // 정상가격표로 보여지기위해 추가
    private String discounted_price;
    private String origin_price;
    private String category_name;
    private String delivery_name;
    


    // 쇼핑카트에 있는 물품개수
    private Integer sc_count;
   
    
}
