package com.shoppingMall.vo;

import java.util.Date;

import lombok.Data;


@Data
public class ReviewAnswerVO {
   private Integer ra_seq;
   private Integer ra_rev_seq;
   private Date ra_reg_dt;
   private Date ra_mod_dt;
   private String ra_content;
   private Integer ra_si_seq;
}
