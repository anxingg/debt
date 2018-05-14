package com.money.debt.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.money.debt")
@MapperScan(basePackages = "com.money.debt.principal.mapper")
public class DebtPrincipalManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtPrincipalManagerApplication.class, args);
	}
}
