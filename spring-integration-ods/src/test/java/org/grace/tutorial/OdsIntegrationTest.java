

package org.grace.tutorial;


import java.nio.channels.Channel;
import org.grace.tutorial.ods.service.ConsumeResourceService;
import org.grace.tutorial.ods.service.ProductService;
import org.grace.tutorial.ods.service.RabbitMQService;
import org.grace.tutorial.ods.service.RejectErrorFilterService;
import org.grace.tutorial.ods.service.TransformService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.test.context.MockIntegrationContext;
import org.springframework.integration.test.context.SpringIntegrationTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringIntegrationOdsApplication.class,})
@SpringBootTest
@SpringIntegrationTest
public class OdsIntegrationTest {

    @Autowired
    private MockIntegrationContext mockIntegrationContext;

    @MockBean
    private ProductService productService;

	@MockBean
	private TransformService transformService;


    @MockBean
    private RejectErrorFilterService rejectErrorFilterService;

    @Captor
    private ArgumentCaptor<String> captor;

    @Captor
    private ArgumentCaptor<byte[]> bytecaptor;

	@Autowired
	private MessageChannel fromRabbit ;

    @AfterEach
    public void tearDown() {
        this.mockIntegrationContext.resetBeans();

    }

    @Test
    public void testMockMessageSource() {

		Mockito.when(transformService.toJson(Mockito.any())).thenReturn("aju");
        Mockito.when(rejectErrorFilterService.accept(Mockito.any())).thenReturn(true);
		Mockito.doNothing().when(productService).createProduct(Mockito.any());

		String payload = "Aju";
		Message<byte[]> message = MessageBuilder.withPayload(payload.getBytes()).build();
		fromRabbit.send(message);

        Mockito.verify(transformService, Mockito.times(0)).toFailedQueue(bytecaptor.capture());
        Mockito.verify(productService, Mockito.times(1)).createProduct(captor.capture());

    }

    @Test
    public void testMockMessageSourceFail() {

        Mockito.when(transformService.toJson(Mockito.any())).thenThrow(new RuntimeException());
        Mockito.when(rejectErrorFilterService.accept(Mockito.any())).thenReturn(true);
        Mockito.doNothing().when(productService).createProduct(Mockito.any());
        String payload = "Aju";
        Message<byte[]> message = MessageBuilder.withPayload(payload.getBytes()).build();
        fromRabbit.send(message);
        Mockito.verify(transformService, Mockito.times(1)).toFailedQueue(bytecaptor.capture());

    }



}
