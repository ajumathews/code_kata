package com.practice.bankservice.fallback;

import com.practice.bankservice.feign.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallBack implements PaymentService {
    @Override
    public String getBalance() {
        return "Try after some time. System down";
    }
}
