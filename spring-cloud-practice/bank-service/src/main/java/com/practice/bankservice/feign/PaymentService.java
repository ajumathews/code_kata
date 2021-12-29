package com.practice.bankservice.feign;

import com.practice.bankservice.fallback.PaymentServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "PAYMENT-SERVICE",fallback = PaymentServiceFallBack.class)
public interface PaymentService {

    @RequestMapping(value = "/payments/balance",method = RequestMethod.GET)
    String getBalance();
}
