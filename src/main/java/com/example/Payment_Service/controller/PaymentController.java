package com.example.Payment_Service.controller;


import com.example.Payment_Service.entity.Payment;
import com.example.Payment_Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment)
    {
        return paymentService.doPayment(payment);
    }
    @GetMapping("/{orderId}")
    public Payment findByOrderId(@PathVariable("orderId") int orderId){
        return paymentService.findByOrderId(orderId);
    }
}
