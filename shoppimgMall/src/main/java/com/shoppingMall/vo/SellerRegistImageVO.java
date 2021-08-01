package com.shoppingMall.vo;

import lombok.Data;

@Data
public class SellerRegistImageVO {
    private Integer sr_seq;
    private Integer sr_si_seq;
    private String sr_uri;
    private String sr_filename;
    private String si_seq;
    private String si_id;
    private String si_name;
    private String si_email;
    private String si_address;
    private String si_phone;
}
