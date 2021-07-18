package com.shoppingMall.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderInfoVO {
   private Integer oi_seq;
   private Integer oi_mi_seq;
   private Integer oi_pi_seq;
   private Date oi_reg_dt;
   private Integer oi_pay_info;
   private String oi_delivery_no;
   private Integer oi_delivery_status;
   private Integer oi_order_status;
   private Integer oi_prod_count;
    
}
