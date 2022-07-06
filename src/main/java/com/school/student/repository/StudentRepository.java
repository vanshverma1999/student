package com.school.student.repository;

import com.school.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    @Query("Select s from Student s where s.city = :city")
    List<Student> getByCity(String city);
}
