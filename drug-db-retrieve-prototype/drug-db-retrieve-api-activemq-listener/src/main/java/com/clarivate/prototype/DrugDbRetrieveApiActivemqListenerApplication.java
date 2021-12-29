package com.clarivate.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
public class DrugDbRetrieveApiActivemqListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrugDbRetrieveApiActivemqListenerApplication.class, args);
    }

    @Autowired
    ConnectionFactory connectionFactory;

    @Autowired
    Jaxb2Marshaller jaxb2Marshaller;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setMessageConverter(messageConverter(jaxb2Marshaller));
		factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
/*

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
*/

    @Bean
    MessageConverter messageConverter(Jaxb2Marshaller marshaller) {
        MarshallingMessageConverter converter = new MarshallingMessageConverter();
        converter.setMarshaller(marshaller);
        converter.setUnmarshaller(marshaller);

        return converter;
    }

}
