package com.money.debt.world;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DebtWorldWebApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDate(){
		System.out.println(new Date(1526183652000l));
	}
}
