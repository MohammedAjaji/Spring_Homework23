package com.example.spring_homework21.Controller;


import com.example.spring_homework21.Model.Course;
import com.example.spring_homework21.Model.Student;
import com.example.spring_homework21.Model.Teacher;
import com.example.spring_homework21.Service.CourseService;
import com.example.spring_homework21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse(){
        List<Course> courses = courseService.getCourses();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course){
        courseService.updateCourse(id,course);
        return ResponseEntity.status(200).body("Course updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("Course deleted");
    }

    @PutMapping("{teacherId}/assign/{courseId}")
    public ResponseEntity assignTeacherToCourse (@PathVariable Integer teacherId, @PathVariable Integer courseId){
        courseService.assignTeacherToCourse(teacherId,courseId);
        return ResponseEntity.status(200).body("Assigning has been successful");
    }


    @GetMapping("/teacher/{courseId}")
    public ResponseEntity getCourseTeacherName(@PathVariable Integer courseId){
        String teacher = courseService.getCourseTeacherName(courseId);
        return ResponseEntity.status(200).body("the name of the teacher in this Course is " + teacher);
    }

    @GetMapping("students/{courseId}")
    public ResponseEntity getStudentOfCourse(@PathVariable Integer courseId){
        Set<Student> studentSet = courseService.getStudentOfCourse(courseId);
        return ResponseEntity.status(200).body(studentSet);
    }


}
