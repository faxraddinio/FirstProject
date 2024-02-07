package com.example.firstproject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Mention with annotations
@RestController
@RequestMapping(path = "api/get")
public class StudentController {

    //instantiated StudentService class

    private final StudentService studentService;

    // Create constructor for it
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // And use methods from the class
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

}
