package com.shoppingMall.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderProductVO {
    private Integer oi_seq;
    private Date oi_reg_dt;
    private String oi_delivery_no;
    private Integer oi_delivery_status;
    private Integer oi_order_status;
    private Integer oi_prod_count;
    private Integer pi_seq;
    private String pi_name;
    private Integer pi_price;
    private Integer pi_discount_rate;
    private Integer pi_point_rate;
    private String pi_img_uri;

    private String final_price;
    private String final_point;
    private String origin_price;
    

    private Boolean review_written;
    private Boolean review_answer;




    

}
