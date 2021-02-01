package com.tommot.sprapp;

import com.tommot.sprapp.models.Student;
import com.tommot.sprapp.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class StudentConfig {

    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            new Student(
                        1L,
                        "John",
                        "Doe",
                        22,
                        LocalDate.of(1993, Month.JUNE,5),
                        "john.doe@gmail.com"
                );
            new Student(
                    1L,
                    "Funto",
                    "Adeoye",
                    25,
                    LocalDate.of(1990, Month.AUGUST,25),
                    "funto.adeoye@gmx.net"
            );
        };
    }
}
