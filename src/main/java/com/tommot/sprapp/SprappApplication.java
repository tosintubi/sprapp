package com.tommot.sprapp;

import com.tommot.sprapp.models.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class SprappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprappApplication.class, args);
	}

	@GetMapping("/greet")
	public List<Student> greet(){
		LocalDate dob= LocalDate.of(1970, Month.JUNE,5);
		return List.of(new Student(
				1L,
				"John",
				"Doe",
				LocalDate.now().getYear()-dob.getYear(),
				dob,
				"john.doe@gmail.com"
		));
	}
}
