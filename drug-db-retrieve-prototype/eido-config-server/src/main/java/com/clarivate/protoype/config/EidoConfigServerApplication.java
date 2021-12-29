package com.clarivate.protoype.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EidoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EidoConfigServerApplication.class, args);
	}

}
