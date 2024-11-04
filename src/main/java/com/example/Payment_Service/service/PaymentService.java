package com.example.Payment_Service.service;

import com.example.Payment_Service.entity.Payment;
import com.example.Payment_Service.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    public Payment doPayment(Payment paymentInput){
        Payment payment=paymentInput;
        payment.setTranscationId(UUID.randomUUID().toString());
        payment.setPaymentStatus(thirdPartypaymentApi());
        return paymentRepo.save(payment);
    }
    //3rd party api call
    public String thirdPartypaymentApi(){
        return new Random().nextBoolean()?"Success":"Fail";
    }

    public Payment findByOrderId(int orderId) {
        Payment payment=paymentRepo.findByOrderId(orderId);
        return payment;
    }
}