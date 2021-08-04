package com.bcp.moneychange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MoneychangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneychangeApplication.class, args);
	}

}
