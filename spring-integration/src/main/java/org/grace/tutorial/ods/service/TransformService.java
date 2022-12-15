package org.grace.tutorial.ods.service;

import java.util.Date;

public class TransformService {

    public String toJson(byte[] message) {
        System.out.println("Message Transforemd to String");
        return new String(message);
    }


    public String toFailedQueue(byte[] message) {
        System.out.println(message);
        return new String(message);
    }
}
