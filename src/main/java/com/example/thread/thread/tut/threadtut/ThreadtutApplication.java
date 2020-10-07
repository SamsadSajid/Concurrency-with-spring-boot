package com.example.thread.thread.tut.threadtut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ThreadtutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadtutApplication.class, args);
	}

}
