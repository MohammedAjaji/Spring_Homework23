package com.example.spring_homework21.Service;

import com.example.spring_homework21.ApiException.ApiException;
import com.example.spring_homework21.Model.Course;
import com.example.spring_homework21.Model.Student;
import com.example.spring_homework21.Model.Teacher;
import com.example.spring_homework21.Repository.CourseRepository;
import com.example.spring_homework21.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student){
        Student oldStudent = studentRepository.findStudentById(id);

        if (oldStudent == null){
            throw new ApiException("Student Not found");
        }

        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);

    }

    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if (student == null){
            throw new ApiException("Student Not found");
        }
        studentRepository.delete(student);
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId){
        Student student = studentRepository.findStudentById(studentId);
        Course course = courseRepository.findCourseById(courseId);
        if (student == null || course == null){
            throw new ApiException("Student ID or Course ID is Wrong");
        }

        student.getCourseSet().add(course);
        course.getStudentSet().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }
    public void changeMajor(Integer studentId, String major){
        Student student = studentRepository.findStudentById(studentId);
        if (student == null){
            throw new ApiException("Student ID Not found");
        }
        student.setMajor(major);
        student.getCourseSet().clear();

        studentRepository.save(student);
    }
}
