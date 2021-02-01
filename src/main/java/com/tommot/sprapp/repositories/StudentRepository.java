package com.tommot.sprapp.repositories;

import com.tommot.sprapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Reposotory responsible for Dao
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
