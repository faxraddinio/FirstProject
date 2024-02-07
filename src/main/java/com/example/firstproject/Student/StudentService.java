package com.example.firstproject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// Mention with annotations
@Service
public class StudentService {

    /*
    For the first time we use StudentService like StudentConfig
    To display students, then we created Student repo to use
    Methods from JpaRepository (for DataBase)
    */

    // instantiated StudentRepo class
    private final StudentRepo studentRepo;

    // Create constructor
    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    // And use methods from StudentRepo (JpaRepository)

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepo.findAll();
//        return List.of(
//                new Student(
//                        1L,
//                        "fakhri",
//                        "mammedovfahri@gmail.com",
//                        LocalDate.of(2004, Month.AUGUST,19),
//                        19
//                ),
//                new Student(
//                        2L,
//                        "maryam",
//                        "maryamkaguliyeva@gmail.com",
//                        LocalDate.of(2005, Month.AUGUST,24),
//                        18
//                )
//        );
    }
}
