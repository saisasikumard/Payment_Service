package com.example.Payment_Service.repository;

import com.example.Payment_Service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {

    Payment findByOrderId(int orderId);
}
