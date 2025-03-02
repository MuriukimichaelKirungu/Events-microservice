package com.example.Payments.service;


import com.example.Payments.entity.Payment;
import com.example.Payments.enums.PaymentStatus;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for handling payment-related operations.
 */
public interface PaymentService {

    /**
     * Initiates a new payment.
     * @param payment The payment details.
     * @return The saved payment.
     */
    Payment initiatePayment(Payment payment);

    /**
     * Retrieves a payment by its transaction ID.
     * @param transactionId The unique transaction ID.
     * @return An optional containing the payment if found.
     */
    Optional<Payment> getPaymentByTransactionId(String transactionId);

    /**
     * Retrieves all payments.
     * @return List of all payments.
     */
    List<Payment> getAllPayments();

    /**
     * Updates the status of a payment.
     * @param transactionId The transaction ID.
     * @param status The new payment status.
     * @return The updated payment.
     */
    Payment updatePaymentStatus(String transactionId, PaymentStatus status);
}

