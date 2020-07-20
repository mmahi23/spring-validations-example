package com.mm.springvalidationexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringValidationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationExampleApplication.class, args);
	}

}
