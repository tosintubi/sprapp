package com.tommot.sprapp.controllers;

import com.tommot.sprapp.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/student")
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
