package com.example.Orders.service;



import com.example.Orders.entity.Order;
import com.example.Orders.entity.OrderStatus;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order); // Create a new order
    Order getOrderById(Long id); // Get order by ID
    List<Order> getOrdersByUser(Long userId); // Get all orders for a user
    Order updateOrderStatus(Long id, String status); // Update order status

    void updateOrderStatus(Long orderId, OrderStatus status);
}

