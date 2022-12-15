

package org.grace.tutorial.hello.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class HelloWorldXmlApp {



	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/hello/helloWorld.xml", HelloWorldXmlApp.class);
		MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
		inputChannel.send(new GenericMessage<String>("World"));
		System.out.println("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());
		context.close();
	}

}
