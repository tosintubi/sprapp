package com.tommot.sprapp.services;


import com.tommot.sprapp.models.Student;
import com.tommot.sprapp.repositories.StudentRepository;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentExists = studentRepository.findStudentByEmail(student.getEmail());

       if (studentExists.isPresent()){
            throw new IllegalStateException("Student email already exists");
        }
        else{
           studentRepository.save(student);
       }
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        if (studentId==null)
            throw new IllegalArgumentException("Invalid Student Id:"+studentId+"\nPlease enter a valid number");
        boolean studentExists = studentRepository.existsById(studentId);
        if (!studentExists)
            throw new IllegalArgumentException("Student with id :"+studentId+" does not exist");
        studentRepository.deleteById(studentId );
    }
}

