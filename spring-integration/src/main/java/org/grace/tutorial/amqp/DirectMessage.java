package org.grace.tutorial.amqp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeoutException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Return;
import com.rabbitmq.client.ReturnCallback;
import org.apache.commons.io.IOUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory.CacheMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory.ConfirmType;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.support.DefaultMessagePropertiesConverter;

public class DirectMessage {


    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost", 5672);
         connectionFactory.setPublisherConfirmType(ConfirmType.SIMPLE);
         connectionFactory.setPublisherReturns(true);
        connectionFactory.setCacheMode(CacheMode.CHANNEL);
        connectionFactory.setConnectionCacheSize(10);

        String messageString ="hello World 2";

        MessageProperties messageProperties = MessagePropertiesBuilder.newInstance()
                .setContentType("application/json")
                .setHeader("utc-timestamp", new Date().getTime()).build();

        Message message = new Message(messageString.getBytes("UTF-8"), messageProperties);

        Connection connection = connectionFactory.createConnection();
        Channel channel = connection.createChannel(false);
        channel.confirmSelect();

        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        AMQP.BasicProperties properties = new DefaultMessagePropertiesConverter()
                .fromMessageProperties(message.getMessageProperties(), "UTF-8");

        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println("Messae published" + l + b);
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println("Messae nacked");
            }
        });

        channel.addReturnListener(new ReturnCallback() {
            @Override
            public void handle(Return aReturn) {
                System.out.println("Return" + aReturn);
            }
        });

        for(int i =0;i< 100000; i++){
            System.out.println("Message Send");
            channel.basicPublish("daps-exchange", "daps-routingKey", true, properties, message.getBody());

        }


        channel.waitForConfirmsOrDie();
        channel.close();



        File file = new File("message.json");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(Feature.ALLOW_COMMENTS, true);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
       mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);


        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            IOUtils.write(mapper.writeValueAsBytes(message), outputStream);
        } catch (Exception e) {
                       throw e;
        }

        System.out.println("File written");
        System.exit(-1);

    }
}
