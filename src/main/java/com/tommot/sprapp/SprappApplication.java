package com.tommot.sprapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SprappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprappApplication.class, args);
	}

	@GetMapping("/greet")
	public String greet(){
		return "hello";
	}
}
