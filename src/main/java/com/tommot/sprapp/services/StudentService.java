package com.tommot.sprapp.services;


import com.tommot.sprapp.models.Student;
import com.tommot.sprapp.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        LocalDate dob= LocalDate.of(1970, Month.JUNE,5);
        return studentRepository.findAll();
    }
}

