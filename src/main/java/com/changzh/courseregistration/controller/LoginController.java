package com.changzh.courseregistration.controller;

import com.changzh.courseregistration.dto.StudentLoginDTO;
import com.changzh.courseregistration.entity.Student;
import com.changzh.courseregistration.service.StudentService;
import com.changzh.courseregistration.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    private StudentService studentService;

    public LoginController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/login")
    public String login(@RequestBody StudentLoginDTO studentLoginDTO) {
        Student db_student = studentService.find(studentLoginDTO.getStudent_id());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(studentLoginDTO.getPassword(), db_student.getPassword())) {
            return JwtUtil.createToken(db_student);
        } else {
            return "Login Failed";
        }
    }

}
