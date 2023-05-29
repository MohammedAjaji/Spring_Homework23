package com.example.spring_homework21.Service;


import com.example.spring_homework21.ApiException.ApiException;
import com.example.spring_homework21.Model.Course;
import com.example.spring_homework21.Model.Teacher;
import com.example.spring_homework21.Repository.CourseRepository;
import com.example.spring_homework21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course){
        Course oldCourse = courseRepository.findCourseById(id);

        if (oldCourse == null){
            throw new ApiException("Course Not found");
        }

        oldCourse.setName(course.getName());

        courseRepository.save(oldCourse);

    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new ApiException("Course Not found");
        }
        courseRepository.delete(course);
    }

    public void assignTeacherToCourse(Integer teacherId, Integer courseId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);
        if(teacher == null || course == null){
            throw new ApiException("Teacher ID or Course ID is Wrong");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String getCourseTeacherName(Integer courseId){
        Course course = courseRepository.findCourseById(courseId);
        if (course == null){
            throw new ApiException("Course Cannot be found");
        }
        Teacher teacher = course.getTeacher();
        return teacher.getName();
    }
}
