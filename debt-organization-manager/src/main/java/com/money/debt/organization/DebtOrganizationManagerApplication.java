package com.money.debt.organization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("com.money.debt")
@MapperScan("com.money.debt.organization.mapper")
public class DebtOrganizationManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtOrganizationManagerApplication.class, args);
	}
}
