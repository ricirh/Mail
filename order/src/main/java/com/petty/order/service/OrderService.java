package com.petty.order.service;

import com.petty.commdity.entity.Goods;
import com.petty.general.response.PageInfo;
import com.petty.order.entity.Order;
import com.petty.order.params.OrderParam;

import java.util.List;

public interface OrderService {

    List<Goods> getGoodList();

    List<Order> getOrderList();

    PageInfo getOrderListByParams(OrderParam param);
}
