package com.example.springbootrestfulapipractice.repository;

import com.example.springbootrestfulapipractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
