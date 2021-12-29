package com.practice.paymentservice.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/payments")
public class PaymentService {


    @RequestMapping(value = "/balance",method = RequestMethod.GET)
    public String getPayment(){
       return "Balance from Service "+ LocalDate.now();
    }

}
