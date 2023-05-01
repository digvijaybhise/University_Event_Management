package com.geekster.UniversityEventmanagement.controller;

import com.geekster.UniversityEventmanagement.model.EDepartment;
import com.geekster.UniversityEventmanagement.model.Student;
import com.geekster.UniversityEventmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    /*Add student
    update student department
    delete student
    Get all students
    Get student by ID*/

    @PostMapping("/")
    public String addStudent(@Valid @RequestBody List<Student> list){
        return studentService.addStudent(list);
    }

    @GetMapping("/")
    public Iterable<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id){
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
    }

    @PutMapping("/department/{department}/id/{id}")
    public void updateStudentDepartment(@PathVariable String department, @PathVariable Integer id){
        studentService.updateDepartmentById(EDepartment.valueOf(department), id);
    }
}
