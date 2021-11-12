package com.petty.general.response;

import lombok.Data;

@Data
public class PageInfo<T> {
    T data;
    long total;
    long pageNum;
    long pageSize;

    public PageInfo(){

    }

    public PageInfo(T data){
        this.data = data;
    }

}
