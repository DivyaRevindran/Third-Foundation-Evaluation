package com.nissan.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AutoGenerator {

// to generate the account number
	public int getAccountNo() {
		Random random = new Random();
		return 100000000 + random.nextInt(900000000);
	}

//to generate the pin
	public int getPin() {
		Random random = new Random();
		return 1000 + random.nextInt(9000);
	}
}