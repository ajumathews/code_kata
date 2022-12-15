package org.grace.tutorial.hello.annotion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class HelloWorldConfigApp {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.grace.tutorial.hello.annotion");
        context.refresh();
        MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
        PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
        inputChannel.send(new GenericMessage<String>("World"));
        System.out.println("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());
        context.close();
    }
}
