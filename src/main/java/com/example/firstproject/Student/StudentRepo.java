package com.example.firstproject.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Mention with annotation
@Repository
public interface StudentRepo extends JpaRepository<Student,Long> { // In JpaRepository generics enter model's class name and ID's data type
}
