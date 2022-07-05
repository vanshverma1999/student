package com.school.student.service;

import com.school.student.model.Student;
import com.school.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    public String addStudent(Student student){
        if(this.studentRepository.existsById(student.getId())){
            return "ID Already exists!";
        }
        else{
            this.studentRepository.save(student);
            return "Details have been added successfully!";
        }
    }

    public String updateStudent(Student student){
        if(this.studentRepository.existsById(student.getId())){
            this.studentRepository.save(student);
            return "Details are updated successfully";
        }
        else{
            return "Student details not in database";
        }
    }

    public String deleteStudent(String id){
        this.studentRepository.deleteById(id);
        return "Details has been deleted";
    }
}
