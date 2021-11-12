package com.petty.commdity.service;

import com.petty.commdity.entity.Goods;
import com.petty.commdity.params.GoodsParam;
import com.petty.general.response.PageInfo;

import java.io.IOException;
import java.util.List;

public interface EsSearchService {

    List<String> findIdsByKeyword(String keyword) throws IOException;

    List<String> findIdsByLabels(List<String> labels);

    List<String> getGoodsListByParams(GoodsParam param, PageInfo pageInfo) throws IOException;
}
