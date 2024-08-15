package com.infnet.microstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroStockApplication.class, args);
		System.out.println("MicroStock API Rodando");
	}

}
