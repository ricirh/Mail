package com.petty.commdity.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    String id;
    String name;
    String descirbe;
    Double price;
    String sourceSite;
    String bind;
}
