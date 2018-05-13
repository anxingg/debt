package com.money.debt.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.money.debt")
public class DebtWorldWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtWorldWebApplication.class, args);
	}
}
