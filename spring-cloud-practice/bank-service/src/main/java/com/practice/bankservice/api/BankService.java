package com.practice.bankservice.api;

import com.practice.bankservice.feign.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/bank")
@Api(value = "Bank api", description = "API endpoints for bank", tags = "bank")
public class BankService {

    private final RestTemplate restTemplate;
    private final PaymentService paymentService;

    @Autowired
    public BankService(RestTemplate restTemplate,PaymentService paymentService) {
        this.restTemplate =restTemplate;
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    @ApiOperation(value = "Get balance value", notes = "get balance notes", nickname = "get balance nickname")
    public String getBalance() {
        String result = paymentService.getBalance();
        return "Calling Payment Service call :" + result;
    }

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    @ApiOperation(value = "Get stocks value", notes = "get stocks notes", nickname = "get stocks nickname")
    public String getStocks() {
        String result = restTemplate.getForObject("http://STOCK-SERVICE/stocks/trending", String.class);

        return "Calling Stock Service call: " + result;
    }

}
