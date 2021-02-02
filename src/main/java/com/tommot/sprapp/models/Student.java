package com.tommot.sprapp.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

