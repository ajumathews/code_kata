

package hello.annotation;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

import org.grace.tutorial.hello.annotion.HelloWorldConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = HelloWorldConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldAnnotionAppTest {

	@Autowired
	MessageChannel inputChannel;

	@Autowired
	PollableChannel outputChannel;



	@Test
	public void testOutputMessage() {
		String payload = "World";
		Message<String> message = MessageBuilder.withPayload(payload).build();
		inputChannel.send(message);
		Message<?> outMessage = outputChannel.receive(10);
		assertNotNull("Expected an output message", outMessage);
		assertEquals("Expected equals", "Hello World", outMessage.getPayload());
	}


}
