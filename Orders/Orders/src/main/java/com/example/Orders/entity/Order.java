package com.example.Orders.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double totalAmount;

    // Ensure this method exists
    @Enumerated(EnumType.STRING)  // Ensure it's mapped as a String in DB
    private OrderStatus status;

    // Constructors
    public Order() {}

    public Order(Long userId, Double totalAmount, OrderStatus status) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
    }

}

