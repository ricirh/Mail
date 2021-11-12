package com.petty.order.service.impl;

import com.github.pagehelper.PageHelper;

import com.petty.commdity.entity.Goods;
import com.petty.commdity.service.GoodsService;
import com.petty.general.response.PageInfo;
import com.petty.order.dao.OrderDao;
import com.petty.order.entity.Order;
import com.petty.order.params.OrderParam;
import com.petty.order.service.OrderService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Reference
    GoodsService goodsService;

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Goods> getGoodList() {
        return goodsService.getGoodList();
    }

    @Override
    public List<Order> getOrderList() {
        return orderDao.getAllOrderList();
    }

    @Override
    public PageInfo getOrderListByParams(OrderParam param) {
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        List<Order> orders = orderDao.getOrderListByParams(param);
        com.github.pagehelper.PageInfo info = new com.github.pagehelper.PageInfo(orders);

        PageInfo pageInfo = new PageInfo(orders);
        pageInfo.setPageNum(info.getPageNum());
        pageInfo.setPageSize(info.getPageSize());
        pageInfo.setTotal(info.getTotal());

        return  pageInfo;
    }
}
