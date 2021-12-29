package org.grace.resttemplate;

import org.grace.resttemplate.model.PaymentBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by U6018134 on 6/25/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class RestTemplateMain {

    public void getPayments(){
        RestTemplate restTemplate = new RestTemplate();
        List<PaymentBean> paymentList=restTemplate.getForObject("http://localhost:7070/budget-service/paymentService/payment/retrieve/201/2018-5-22",List.class);
        System.out.println(paymentList.size());
    }


    public void validateUser(){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.add("emailAddress", "mathews.aju2@gmail.com");
        parameters.add("password", "password123");

        String s =restTemplate.postForObject("http://localhost:7070/budget-service/userService/user/validate",parameters,String.class);
        System.out.println(s);

    }

    public static void main(String[] args) {
        RestTemplateMain restTemplateMain = new RestTemplateMain();
        restTemplateMain.validateUser();
    }
}
