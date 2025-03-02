package com.example.Orders.entity;


public enum OrderStatus {
    PENDING, // Order is created but not paid
    PAID,    // Order has been successfully paid
    CANCELLED // Order is cancelled
}

