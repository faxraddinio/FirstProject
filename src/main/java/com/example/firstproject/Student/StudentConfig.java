package com.example.firstproject.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// Mention with annotations
@Configuration
public class StudentConfig {

    // Mention with annotations (if not, it doesn't work)
    //Use CommandLineRunner to return our students like argument (in argument it accepts StudentRepo)
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo){
        return args -> {
            Student fakhri = new Student(
                          "fakhri",
                          "mammedovfahri@gmail.com",
                          LocalDate.of(2004, Month.AUGUST,19),
                          19
            );
            Student maryam = new Student(
                        "maryam",
                        "maryamkaguliyeva@gmail.com",
                        LocalDate.of(2005, Month.AUGUST,24),
                        18
            );

            // Now save all students (one by one or all together)
            repo.saveAll(
                    List.of(fakhri, maryam)
            );
        };
    }

}
