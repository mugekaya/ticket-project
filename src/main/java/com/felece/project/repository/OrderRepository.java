package com.felece.project.repository;

import com.felece.project.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {


    List<Order> findAllByOrderStatus(String orderStatus);

    List<Order> findAllByOrderStatusNotContains(String status);
}