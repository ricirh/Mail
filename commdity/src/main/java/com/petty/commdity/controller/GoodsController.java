package com.petty.commdity.controller;

import com.petty.commdity.entity.Goods;
import com.petty.commdity.params.GoodsParam;
import com.petty.commdity.service.GoodsService;
import com.petty.general.response.PageInfo;
import com.petty.general.response.R;
import com.petty.general.response.ResponseCode;
import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/goods")
@Api(tags = "商品")
public class GoodsController {
    static Logger log = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    GoodsService goodsService;

    @GetMapping("/list")
    R getGoodsList(){
        return R.ok(goodsService.getGoodList(),"查询成功");
    }

    @PostMapping("/listByPage")
    R getGoodsListByParams(@RequestBody GoodsParam param){
        PageInfo list = null;
        try{
            list = goodsService.getGoodsListByParams(param);
        }catch (Exception e){
            log.error(e.getMessage());
            return R.fail(ResponseCode.QUERYERROR,e.getMessage());
        }
        return R.ok(list);
    }

}
