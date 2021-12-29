package org.practice.jdbceurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JdbcEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcEurekaServerApplication.class, args);
	}

}
