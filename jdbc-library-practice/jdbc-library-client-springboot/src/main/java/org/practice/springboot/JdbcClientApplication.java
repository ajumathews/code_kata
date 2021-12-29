package org.practice.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.practice")
public class JdbcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcClientApplication.class, args);
	}

}
