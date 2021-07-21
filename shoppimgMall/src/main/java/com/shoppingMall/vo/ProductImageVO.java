package com.shoppingMall.vo;



import java.util.Date;

import lombok.Data;

@Data
public class ProductImageVO {
    
   private Integer pimg_seq;
   private String pimg_file_name;
   private String pimg_uri;
   private Date pimg_reg_dt;
   private Integer pimg_size;
}
