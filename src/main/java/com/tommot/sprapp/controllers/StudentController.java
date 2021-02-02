package com.tommot.sprapp.controllers;

import com.tommot.sprapp.models.Student;
import com.tommot.sprapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Returns lists of registered students.
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    // Register a new student.
    @PostMapping("/new")
    public ResponseEntity registerStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Delete student using studentId
    @DeleteMapping(path = "{studentId}")
    public ResponseEntity deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

}
