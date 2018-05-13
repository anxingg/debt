package com.money.debt.position;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.money.debt")
@MapperScan(basePackages = "com.money.debt.position.mapper")
public class DebtPositionManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DebtPositionManagerApplication.class, args);
	}
}
