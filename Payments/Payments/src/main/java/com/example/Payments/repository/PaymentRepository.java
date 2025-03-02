package com.example.Payments.repository;



import com.example.Payments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Payment entities.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    /**
     * Find a payment by its transaction ID.
     * @param transactionId the unique transaction ID
     * @return an Optional containing the Payment if found
     */
    Optional<Payment> findByTransactionId(String transactionId);
}

