package com.example.firstproject.Student;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

/*
* Model of Student entity
*/
@Entity
@Table
public class Student {

    @Id
    /*
    * Using @SequenceGenerator to automatically give an ID to every created student (allocationSize = 1)
    */
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence" // mention here that we use the ID generator from our @SequenceGenerator
    )
    Long id;
    String name;
    String email;
    LocalDate dob;
    @Transient
    Integer age; // so age are dynamic var, we exclude "age" from table and remove it from constructor params

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob) { // remove age from here
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    /*
    * Create constructor without ID (because our generator will generate the ID automatically)
    */

    public Student(String name, String email, LocalDate dob) { // remove age from here
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() { // and ve get the age from this mechanism, we calculate period between dob and now and return years
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
