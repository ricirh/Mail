package com.petty.merchant.service;

import com.petty.general.response.PageInfo;
import com.petty.merchant.entity.Store;
import com.petty.merchant.vo.StoreListParam;

import java.io.IOException;
import java.util.List;

public interface StoreEsSearchService {

    List<Store> findByName(String name) throws IOException;

    List<Store> findByField(String keyword);

    PageInfo getStoreListByParams(StoreListParam param) throws IOException;
}
