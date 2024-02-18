package com.example.firstproject.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    }

    //post method functionality

    public void addNewStudent(Student student) { // here ve create method that output student details in JSON format in console
        Optional<Student> optionalStudentEmail = studentRepo.findAllByEmail(student.getEmail()); // create a var for check if user email is exist in database

        if (optionalStudentEmail.isPresent()){ // checking if email is present in database
            throw new IllegalStateException("email is using"); // trowing exertion
        }

        studentRepo.save(student); // if not present save student
//        System.out.println(student);

    }


    public void deleteStudent(Long studentID) {
      boolean exist = studentRepo.existsById(studentID);//USING existsById we check if database have that id, if yes delete that student, else throwing exception

      if (!exist){
          throw new IllegalStateException("the id " + studentID + " doesnt exist");
      }

      //We also can do this way
//        Optional<Student> student = studentRepo.findById(studentID);
//
//        if (student.isEmpty()){
//            throw new IllegalStateException("student with id " + studentID + " not exist");
//        }
        studentRepo.deleteById(studentID);
        
    }



    // we use it because if something goes wrong in some block of code , it doest save any changes and throw error
    // without this annotation if I have a problem in first or second block of code, changes will be saved in correct block of code but not in error block of code
    @Transactional
    public void updateExistStudent(Long id, Student studentDetails) {
        Student exist_student = studentRepo.findById(id)
                .orElseThrow(() -> new  IllegalStateException("Student with given id" + id + "is not found"));

        if (!(studentDetails.getName().length() == 0)
                && !(studentDetails.getName() == null)
                && !Objects.equals(exist_student.getName(), studentDetails.getName())){
            Optional<Student> student = studentRepo.findByName(studentDetails.getName());
            if (student.isPresent()){
                throw new IllegalStateException("name is taken");
            }
            exist_student.setName(studentDetails.getName());
        }



        if (!(studentDetails.getEmail() == null)
                && !(studentDetails.getEmail().length() == 0)
                && !Objects.equals(exist_student.getEmail(), studentDetails.getEmail())){
            Optional<Student> student = studentRepo.findByEmail(studentDetails.getEmail());
            if (student.isPresent()){
                throw new IllegalStateException("email is taken");
            }

            exist_student.setEmail(studentDetails.getEmail());
        }



        studentRepo.save(exist_student);


    }
}
