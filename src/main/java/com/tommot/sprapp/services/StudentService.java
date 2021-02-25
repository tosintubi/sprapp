package com.tommot.sprapp.services;


import com.tommot.sprapp.models.Student;
import com.tommot.sprapp.repositories.StudentRepository;
import com.tommot.sprapp.utils.CustomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateStudent(Long studentId, String lastName, String email) {
        //Validate Email, throws new IllegalArgumentException if email is invalid.
        if (!CustomUtils.isValidEmail(email))
            throw new IllegalArgumentException("Email address: "+email+" is invalid");

        // Finds student using supplied Id
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student with Id: "+ studentId +" does not exist"));

        //Updates lastName if different.
        if(lastName != null && lastName.length()> 0 && !StringUtils.equals(student.getLastName(), lastName)){
            student.setLastName(lastName);
        }

        // Checks if supplied email is taken
        if (email!=null && email.length()> 0 && !StringUtils.equals(student.getEmail(),email)) {
            Optional<Student> studentByEmailExists = studentRepository.findStudentByEmail(email);
            if (studentByEmailExists.isPresent()){
                throw new IllegalStateException("Email address: "+email+" is already taken");
            }
            //Sets the email
            student.setEmail(email);
        }
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }
}

