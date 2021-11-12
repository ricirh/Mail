package com.petty.commdity.service;

import com.petty.commdity.entity.Goods;
import com.petty.commdity.params.GoodsParam;
import com.petty.general.response.PageInfo;

import java.io.IOException;
import java.util.List;

public interface GoodsService {
    List<Goods> getGoodList();
    PageInfo getGoodsListByParams(GoodsParam param) throws IOException;

}
