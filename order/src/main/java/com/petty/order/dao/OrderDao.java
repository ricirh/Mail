package com.petty.order.dao;

import com.petty.order.entity.Order;
import com.petty.order.params.OrderParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    List<Order> getAllOrderList();

    List<Order> getOrderListByParams(OrderParam param);
}
