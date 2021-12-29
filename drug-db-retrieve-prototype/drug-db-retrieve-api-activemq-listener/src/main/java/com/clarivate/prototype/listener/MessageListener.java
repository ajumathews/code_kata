package com.clarivate.prototype.listener;

import com.clarivate.prototype.model.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

/*
    @JmsListener(destination = "myTestQueue")
    public void receiveMessage(String text){
        System.out.println("Message Recieved :"+text);
    }
*/


    @JmsListener(destination = "myTestQueue", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Order order) {
        System.out.println("Message Recieved :" + order.toString());
    }


}
