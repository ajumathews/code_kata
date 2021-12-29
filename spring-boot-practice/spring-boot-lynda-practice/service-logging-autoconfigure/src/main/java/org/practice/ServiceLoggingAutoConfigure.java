package org.practice;

import com.practice.logging.LoggingAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(LoggingAspect.class)
public class ServiceLoggingAutoConfigure {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
