package com.example.gurukul.repository;

import com.example.gurukul.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(String id);
}
