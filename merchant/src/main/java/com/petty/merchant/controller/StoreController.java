package com.petty.merchant.controller;

import com.petty.general.response.R;
import com.petty.merchant.service.StoreService;
import com.petty.merchant.vo.StoreListParam;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Api(tags = "店铺")
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping("/getStoreList")
    R getStoreListByParms(@RequestParam StoreListParam param) throws IOException {
        storeService.getStoreListByParams(param);
        return null;
    }

}
