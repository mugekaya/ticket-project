package com.felece.project.service.impl;

import com.felece.project.entity.Order;
import com.felece.project.repository.OrderRepository;
import com.felece.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId).get();
    } //orderid ile orderın tüm bilgilerini aldik

    @Override
    public Order updateOrder(Order newOrder) {
        //update aynı işlevi save'in.
        return orderRepository.save(newOrder);
    }

    @Override
    public Order cancelOrder(Long orderId) {

        Order order = orderRepository.getById(orderId);
        order.setOrderStatus("Iptal Edildi.");
        return orderRepository.save(order);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrderByStatus(String status) {
        return orderRepository.findAllByOrderStatus(status);
    }


}
