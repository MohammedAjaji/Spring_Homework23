package com.example.spring_homework21.Controller;

import com.example.spring_homework21.Model.Teacher;
import com.example.spring_homework21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        List<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("Teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher deleted");
    }

    @GetMapping("get-id/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
       Teacher teacher =  teacherService.getTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }
}
