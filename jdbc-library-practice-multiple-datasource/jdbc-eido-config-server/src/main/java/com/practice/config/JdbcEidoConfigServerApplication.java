package com.practice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class JdbcEidoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcEidoConfigServerApplication.class, args);
	}

}
