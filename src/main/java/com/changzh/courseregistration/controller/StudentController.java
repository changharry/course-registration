package com.changzh.courseregistration.controller;

import com.changzh.courseregistration.entity.Student;
import com.changzh.courseregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
    public Student addStudent(@RequestBody Student student) {
        student.setStudent_id(0);
        studentService.save(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
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

    @PutMapping("/students/{student_id}/{course_id}")
    public String addCourse(@PathVariable int student_id, @PathVariable String course_id) {
        studentService.addCourse(student_id, course_id);
        return "Success!";
    }
}
