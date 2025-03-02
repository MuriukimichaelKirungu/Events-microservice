package com.example.Payments.service;

import com.example.Payments.entity.Payment;
import com.example.Payments.enums.PaymentStatus;
import com.example.Payments.repository.PaymentRepository;
import com.example.Payments.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of PaymentService to handle business logic for payments.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    /**
     * Constructor-based dependency injection for PaymentRepository.
     */
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment initiatePayment(Payment payment) {
        payment.setStatus(PaymentStatus.PENDING);  // Set initial status as PENDING
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> getPaymentByTransactionId(String transactionId) {
        return paymentRepository.findByTransactionId(transactionId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePaymentStatus(String transactionId, PaymentStatus status) {
        Optional<Payment> paymentOptional = paymentRepository.findByTransactionId(transactionId);

        if (paymentOptional.isPresent()) {
            Payment payment = paymentOptional.get();
            payment.setStatus(status);
            return paymentRepository.save(payment);
        } else {
            throw new RuntimeException("Payment with transaction ID " + transactionId + " not found.");
        }
    }
}