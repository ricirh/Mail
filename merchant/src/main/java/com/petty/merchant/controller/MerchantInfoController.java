package com.petty.merchant.controller;

import com.petty.general.response.R;
import com.petty.merchant.service.MerchantService;
import com.petty.merchant.vo.MerchantLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "登陆信息")
@RestController
@RequestMapping("/merchant")
public class MerchantInfoController {

    @Autowired
    MerchantService merchantService;

    @ApiOperation("登陆")
    @PostMapping("/login")
    R login(@RequestBody MerchantLoginVO loginVO){
        merchantService.login(loginVO);
        return R.ok();
    }

    @ApiOperation("信息")
    @GetMapping("/getInfo")
    R getStoreInfo(){
        return R.ok();
    }


}
