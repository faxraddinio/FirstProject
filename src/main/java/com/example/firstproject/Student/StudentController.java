package com.example.firstproject.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //post mapping
    @PostMapping("/post/student")
    public void addNewStudent (@RequestBody Student student){// post method has request body so ve annotate it here
        studentService.addNewStudent(student); // and we output the new student, it output in console when we do post request
    }

    @DeleteMapping("/delete/{id}")//indicate the {id} here like path and in params too like @PathVariable to search and delete by ID
    public void deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
    }


    @PutMapping("/update/{studentId}")
    public void updateExistStudent(@PathVariable Long studentId, @RequestBody Student studentDetails) {// put request get id as pathVariable to find by id and update/modify student details and requestBody like this param will be accepting an arguments
        studentService.updateExistStudent(studentId, studentDetails);
    }

}
