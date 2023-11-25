package net.ayanfedev.springboot.controller;

import net.ayanfedev.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Victor",
                "Ubuju"
        );
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John", "Ubuju"));
        students.add(new Student(2, "Jude", "Utemu"));
        students.add(new Student(3, "Matt", "Mulata"));
        students.add(new Student(4, "Henry", "Phineas"));
        return students;
    }

    // Spring Boot REST API with Path Variable
    //    {id} - URI template variable
    //     http://localhost:8080/students/1
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // Spring Boot REST API with Request Parameters
    // http://localhost:8080/students/query?id=1&firstName=Femyk&lastName=Fatai
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }


}
