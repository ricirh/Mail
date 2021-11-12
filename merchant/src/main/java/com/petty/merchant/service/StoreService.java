package com.petty.merchant.service;


import com.petty.general.response.PageInfo;
import com.petty.merchant.vo.StoreListParam;

import java.io.IOException;

public interface StoreService {
    PageInfo getStoreListByParams(StoreListParam param) throws IOException;
}
