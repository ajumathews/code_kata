package com.practice.stockservice.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/stocks")
public class StockService {

    @RequestMapping(value = "/trending",method = RequestMethod.GET)
    public String getPayment(){
       return "Latest Trending Stocks "+ LocalDate.now();
    }

}
