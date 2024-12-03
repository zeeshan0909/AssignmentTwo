package com.ansari.HomeWork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeWorkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HomeWorkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("check the project is working fine or not");
	}
}
