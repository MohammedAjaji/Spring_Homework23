package com.example.spring_homework21.Service;

import com.example.spring_homework21.ApiException.ApiException;
import com.example.spring_homework21.Model.Course;
import com.example.spring_homework21.Model.Teacher;
import com.example.spring_homework21.Repository.CourseRepository;
import com.example.spring_homework21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);

        if (oldTeacher == null){
            throw new ApiException("Teacher Not found");
        }

        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());

        teacherRepository.save(oldTeacher);

    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("Teacher Not found");
        }
        List<Course> courses = courseRepository.findCourseByTeacher(teacher);
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).setTeacher(null);
        }

        teacherRepository.delete(teacher);
    }

    public Teacher getTeacherById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null){
            throw new ApiException("Teacher Not found");
        }
        return teacher;
    }
}
