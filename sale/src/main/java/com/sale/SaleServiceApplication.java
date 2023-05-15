package com.sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class SaleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaleServiceApplication.class, args);
	}

}
