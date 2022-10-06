package com.changzh.courseregistration.controller;

import com.changzh.courseregistration.entity.Student;
import com.changzh.courseregistration.service.StudentService;
import com.changzh.courseregistration.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private StudentService studentService;

    public LoginController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/login")
    public String login(@RequestBody Student student) {
        Student db_student = studentService.find(student.getStudent_id());
        if (db_student.getPassword().equals(student.getPassword())) {
            return JwtUtil.createToken(db_student);
        } else {
            return "Login Failed";
        }
    }

}
