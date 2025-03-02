package com.example.Payments.controller;

import com.example.Payments.entity.Payment;
import com.example.Payments.enums.PaymentStatus;
import com.example.Payments.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for handling payment-related API endpoints.
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    /**
     * Constructor-based dependency injection for PaymentService.
     */
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Endpoint to initiate a new payment.
     * @param payment The payment details.
     * @return The created payment.
     */
    @PostMapping("/initiate")
    public ResponseEntity<Payment> initiatePayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.initiatePayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    /**
     * Endpoint to retrieve a payment by its transaction ID.
     * @param transactionId The unique transaction ID.
     * @return The payment details if found.
     */
    @GetMapping("/{transactionId}")
    public ResponseEntity<Payment> getPaymentByTransactionId(@PathVariable String transactionId) {
        Optional<Payment> payment = paymentService.getPaymentByTransactionId(transactionId);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to retrieve all payments.
     * @return List of all payments.
     */
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    /**
     * Endpoint to update the status of a payment.
     * @param transactionId The transaction ID.
     * @param status The new payment status.
     * @return The updated payment.
     */
    @PutMapping("/{transactionId}/status")
    public ResponseEntity<Payment> updatePaymentStatus(
            @PathVariable String transactionId,
            @RequestParam PaymentStatus status) {

        Payment updatedPayment = paymentService.updatePaymentStatus(transactionId, status);
        return ResponseEntity.ok(updatedPayment);
    }
}