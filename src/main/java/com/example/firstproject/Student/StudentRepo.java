package com.example.firstproject.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Mention with annotation
@Repository
public interface StudentRepo extends JpaRepository<Student,Long> { // In JpaRepository generics enter model's class name and ID's data type
    Optional<Student> findAllByEmail( String email ); // create a method that can find student by email using optional

    Optional<Student> findByEmail( String email );

    Optional<Student> findByName(String name);
    //we use optional for future checking if email, name or smthk are present in database, so we can throw an exception

}
