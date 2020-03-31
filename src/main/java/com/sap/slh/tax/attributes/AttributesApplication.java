package com.sap.slh.tax.attributes;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.sap.slh.tax.*")
@SpringBootApplication
@EnableRabbit
public class AttributesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttributesApplication.class, args);
	}

}
