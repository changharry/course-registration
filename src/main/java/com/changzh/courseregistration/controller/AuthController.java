package com.changzh.courseregistration.controller;

import com.changzh.courseregistration.exception.UnAuthorizedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.changzh.courseregistration.util.JwtUtil.verifyToken;

@RestController
@CrossOrigin
public class AuthController {


    @RequestMapping("/auth")
    public String authStatus(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (verifyToken(token) == null) {
            throw new UnAuthorizedException("Unauthorized!");
        } else {
            return "Authorized!";
        }
    }
}
