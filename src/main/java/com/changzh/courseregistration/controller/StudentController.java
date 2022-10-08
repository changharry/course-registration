package com.changzh.courseregistration.controller;

import com.changzh.courseregistration.dto.StudentDetailDTO;
import com.changzh.courseregistration.entity.Course;
import com.changzh.courseregistration.entity.Student;
import com.changzh.courseregistration.service.CourseService;
import com.changzh.courseregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    private CourseService courseService;

    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{student_id}")
    public Student find(@PathVariable int student_id) {
        Student student = studentService.find(student_id);
        if (student == null) {
            throw new RuntimeException(String.format("Student: %s not found!", student_id));
        }
        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody StudentDetailDTO studentDetailDTO) {
        studentDetailDTO.setStudent_id(0);
        Student student = studentDetailDTO.daoMapper();
        studentService.save(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody StudentDetailDTO studentDetailDTO) {
        Student student = studentDetailDTO.daoMapper();
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/students/{student_id}")
    public String deleteStudent(@PathVariable int student_id) {
        Student student = studentService.find(student_id);
        if (student == null) {
            throw new RuntimeException(String.format("Student: %s not found!", student_id));
        }
        studentService.delete(student_id);
        return "Deleted!";
    }

    @PostMapping("/students/{student_id}/{course_id}")
    public String addCourse(@PathVariable int student_id, @PathVariable String course_id) {
        Student student = studentService.find(student_id);
        if (student == null) {
            throw new RuntimeException(String.format("Student: %s not found!", student_id));
        }
        Course course = courseService.find(course_id);
        if (course == null) {
            throw new RuntimeException(String.format("Course: %s not found!", course_id));
        }
        studentService.addCourse(student_id, course_id);
        return "Success!";
    }
    @GetMapping("/students/{student_id}/enrolled")
    public List<Course> enrolledCourse(@PathVariable int student_id) {
        Student student = studentService.find(student_id);
        if (student == null) {
            throw new RuntimeException(String.format("Student: %s not found!", student_id));
        }
        return studentService.enrolledCourse(student_id);
    }
}
