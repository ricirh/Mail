package com.petty.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Order implements Serializable {
    private String id;
    private String goodId;
    private String userId;
    private Date createTime;
    private String destination;
    private String remark;
    private Integer status;
}
