package com.tommot.sprapp.repositories;

import com.tommot.sprapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// Reposotory responsible for Dao
@Repository
public interface  StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s from Student s WHERE s.email=?1 ")
    Optional<Student> findStudentByEmail(String email);
}
