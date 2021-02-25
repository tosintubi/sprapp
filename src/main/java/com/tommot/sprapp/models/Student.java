package com.tommot.sprapp.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id", updatable = false
    )
    private Long id;

    @Column(
            name = "firstName",
            updatable = false,
            nullable = false
    )
    private String firstName;

    @Column(
            name="lastName"
    )
    private String lastName;
    @Transient
    private Integer age;
    private LocalDate dob;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName,  LocalDate dob, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
    }

    public Student(String firstName, String lastName, LocalDate dob, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
    }
}

