package com.money.debt.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.money.debt")
public class DebtOrganizationWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtOrganizationWebApplication.class, args);
	}
}
