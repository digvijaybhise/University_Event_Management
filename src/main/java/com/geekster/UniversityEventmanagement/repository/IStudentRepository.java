package com.geekster.UniversityEventmanagement.repository;

import com.geekster.UniversityEventmanagement.model.EDepartment;
import com.geekster.UniversityEventmanagement.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Integer> {

    public Student findByStudentId(Integer id);

    @Modifying
    @Query(value = "Update Student set DEPARTMENT = :department where STUDENT_ID = :id", nativeQuery = true)
    public void updateDepartmentByStudentId(String department, Integer id);

}
