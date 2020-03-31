package com.sap.slh.tax.attributes;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("com.sap.slh.tax.*")
@SpringBootApplication
@EnableRabbit
@EnableAsync
public class AttributesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttributesApplication.class, args);
	}

}
