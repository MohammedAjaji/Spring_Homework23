package com.example.spring_homework21.Repository;

import com.example.spring_homework21.Model.Course;
import com.example.spring_homework21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(Integer id);
    List<Course> findCourseByTeacher(Teacher teacher);

}
