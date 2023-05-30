package com.example.spring_homework21.Repository;

import com.example.spring_homework21.Model.Course;
import com.example.spring_homework21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
    List<Student> findStudentByCourseSetContains(Course course);
}
