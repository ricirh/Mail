package com.petty.order.controller;


import com.petty.general.response.R;
import com.petty.order.params.OrderParam;
import com.petty.order.service.OrderService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "订单")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getGoodsInfo")
    R getGoodInfo(){
        return R.ok(orderService.getGoodList());
    }


    @GetMapping("/getOrderList")
    R getOrderList(){
        return R.ok(orderService.getOrderList());
    }

    @GetMapping("/getOrderListByParams")
    R getOrderListByParms(OrderParam param){
        return R.ok(orderService.getOrderListByParams(param));
    }

}
