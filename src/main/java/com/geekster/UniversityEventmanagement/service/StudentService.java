package com.geekster.UniversityEventmanagement.service;

import com.geekster.UniversityEventmanagement.model.EDepartment;
import com.geekster.UniversityEventmanagement.model.Student;
import com.geekster.UniversityEventmanagement.repository.IStudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    IStudentRepository studentRepository;

    public String addStudent(List<Student> list) {
        Iterable<Student> studentList = studentRepository.saveAll(list);
        if (studentList != null){
            return "Student list gets added...!!!";
        }
        return "Could not added student list";
    }

    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Integer id) {
        return studentRepository.findByStudentId(id);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateDepartmentById(EDepartment department, Integer id) {
        studentRepository.updateDepartmentByStudentId(department.toString(), id);
    }
}
