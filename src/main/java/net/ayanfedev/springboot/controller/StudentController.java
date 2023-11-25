package net.ayanfedev.springboot.controller;

import net.ayanfedev.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Spring Boot REST API that handles HTTP POST Request -- creating new resource
    // @PostMapping and RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


    // Spring Boot REST API that handles HTTP PUT Request -- updating existing resource
    //
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


}
