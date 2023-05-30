package com.example.spring_homework21.Controller;

import com.example.spring_homework21.Model.Course;
import com.example.spring_homework21.Model.Student;
import com.example.spring_homework21.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        List<Student> students = studentService.getStudent();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @Valid @RequestBody Student student){
        studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body("Student updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("Student deleted");
    }

    @PutMapping("{studentId}/assign/{courseId}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer studentId, @PathVariable Integer courseId){
        studentService.assignStudentToCourse(studentId,courseId);
        return ResponseEntity.status(200).body("Assigning has been successful");
    }

    @PutMapping("{studentId}/change/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer studentId, @PathVariable String major ){
        studentService.changeMajor(studentId,major);
        return ResponseEntity.status(200).body("Major Has Been Changed");
    }
}
