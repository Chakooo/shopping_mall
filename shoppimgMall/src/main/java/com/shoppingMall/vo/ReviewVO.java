package com.shoppingMall.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
private Integer rev_seq;
private Integer rev_pi_seq;
private Integer rev_mi_seq;
private Date rev_reg_dt;
private Date rev_mod_dt;
private String rev_content;
private Integer rev_rate;    
private Integer rev_oi_seq;

private String result_reg_dt;
private String result_mod_dt;

// 리뷰정보 가져오기위한 vo변수 추가
private Integer si_seq;
private String pi_name;
private Integer pi_price;
private String mi_id;
}
