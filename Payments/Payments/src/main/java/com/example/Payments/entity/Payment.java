package com.example.Payments.entity;


import com.example.Payments.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entity class representing a Payment in the system.
 */
@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the payment

    @Column(nullable = false)
    private String transactionId;  // Unique transaction ID for reference

    @Column(nullable = false)
    private Long orderId;  // ID of the order associated with this payment

    @Column(nullable = false)
    private String phoneNumber;  // Customer's phone number for M-Pesa transactions

    @Column(nullable = false)
    private Double amount;  // Payment amount

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;  // Payment status (PENDING, SUCCESS, FAILED)

    @Column(nullable = false)
    private LocalDateTime paymentDate;  // Timestamp when payment was made

    @PrePersist
    protected void onCreate() {
        this.paymentDate = LocalDateTime.now();  // Set payment time when the entity is created
    }
}
