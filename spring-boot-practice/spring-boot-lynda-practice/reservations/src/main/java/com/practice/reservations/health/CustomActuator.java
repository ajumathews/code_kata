package com.practice.reservations.health;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="system-details")
public class CustomActuator {

    @ReadOperation
    public String getDetails(){
        return "This is demo system";
    }
}
