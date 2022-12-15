package org.grace.tutorial.ods.service;

public class TransformService {

    private RabbitMQService rabbitMQService;

    public void setRabbitMQService(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    public String toJson(byte[] message) {
        System.out.println("Message Transforemd to String");
        return new String(message);
    }


    public String toFailedQueue(byte[] message) {
        System.out.println("Failed");
        rabbitMQService.sendFailedMessage(message);
        return new String(message);
    }
}
