package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${message}")
    private String message;

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "hello " + message;
    }
}
