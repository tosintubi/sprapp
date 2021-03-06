package com.tommot.sprapp.controllers;

import com.tommot.sprapp.models.Student;
import com.tommot.sprapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
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

    //Search student using StudentId
    @GetMapping("{studentId}")
    public Optional<Student> getStudent(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
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

    //Update Student information
    @PutMapping(path="{studentId}")
    public ResponseEntity updateStudent(@PathVariable("studentId") Long studentId,
                                        @RequestParam(required = false) String lastName,
                                        @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, lastName, email);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

}
