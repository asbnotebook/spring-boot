package com.asb.example;

import org.springframework.boot.CommandLineRunner;

public class StartupRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Command Line Runner class invoked!!");
	}
}