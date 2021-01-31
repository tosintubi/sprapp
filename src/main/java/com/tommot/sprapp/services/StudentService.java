package com.tommot.sprapp.services;


import com.tommot.sprapp.models.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
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

