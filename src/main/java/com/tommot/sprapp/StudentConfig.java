package com.tommot.sprapp;

import com.tommot.sprapp.models.Student;
import com.tommot.sprapp.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
           Student john =  new Student(
                        "John",
                        "Doe",
                        22,
                        LocalDate.of(1993, Month.JUNE,5),
                        "john.doe@gmail.com"
                );
           Student funto =  new Student(
                    "Funto",
                    "Adeoye",
                    25,
                    LocalDate.of(1990, Month.AUGUST,25),
                    "funto.adeoye@gmx.net"
            );
            studentRepository.saveAll(List.of(john,funto));
        };
    }
}
