package com.felece.project.service;

import com.felece.project.entity.Order;

import java.util.List;

public interface OrderService {
    Order findOrderById(Long orderId);

    Order updateOrder(Order newOrder);

    Order cancelOrder(Long orderId);

    Order createOrder(Order order);

    List<Order> getAllOrder();

    List<Order> getOrderByStatus(String status);
}
