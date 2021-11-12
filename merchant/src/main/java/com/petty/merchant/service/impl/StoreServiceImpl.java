package com.petty.merchant.service.impl;

import com.petty.general.response.PageInfo;
import com.petty.merchant.entity.Store;
import com.petty.merchant.service.StoreEsSearchService;
import com.petty.merchant.service.StoreService;
import com.petty.merchant.vo.StoreListParam;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreEsSearchService storeEsSearchService;

    @Override
    public PageInfo getStoreListByParams(StoreListParam param) throws IOException {

        return  storeEsSearchService.getStoreListByParams(param);

    }
}
