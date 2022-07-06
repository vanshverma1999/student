package com.school.student.controller;

import com.school.student.model.Student;
import com.school.student.repository.StudentRepository;
import com.school.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudents(){
        return this.studentService.getStudents();
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") String id){
        return this.studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student){return this.studentService.updateStudent(student);}

    @GetMapping("/student/{city}")
    public ResponseEntity findStudentsByCity(@PathVariable("city") String city){
        return ResponseEntity.ok(studentService.findAllByCity(city));
    }
}
