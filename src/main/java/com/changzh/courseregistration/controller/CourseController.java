package com.changzh.courseregistration.controller;

import com.changzh.courseregistration.entity.Course;
import com.changzh.courseregistration.entity.Student;
import com.changzh.courseregistration.exception.NoPrivilegeException;
import com.changzh.courseregistration.service.CourseService;
import com.changzh.courseregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping("/courses/{courseID}")
    public Course find(@PathVariable String courseID) {
        Course course = courseService.find(courseID);
        if (course == null) {
            throw new RuntimeException(String.format("Course: %s not found!", courseID));
        }
        return course;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course, HttpServletRequest httpServletRequest) {
        if ((int) httpServletRequest.getAttribute("student_id") != 1) {
            throw new NoPrivilegeException("No Privilege!");
        }
        courseService.save(course);
        return course;

    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course, HttpServletRequest httpServletRequest) {
        if ((int) httpServletRequest.getAttribute("student_id") != 1) {
            throw new NoPrivilegeException("No Privilege!");
        }
        courseService.save(course);
        return course;
    }

    @DeleteMapping("/courses/{courseID}")
    public String deleteCourse(@PathVariable String courseID, HttpServletRequest httpServletRequest) {
        if ((int) httpServletRequest.getAttribute("student_id") != 1) {
            throw new NoPrivilegeException("No Privilege!");
        }
        Course course = courseService.find(courseID);
        if (course == null) {
            throw new RuntimeException(String.format("Course: %s not found!", courseID));
        }
        courseService.delete(courseID);
        return "Deleted!";
    }
    @PostMapping("/courses/{course_id}/{student_id}")
    public String addStudent(@PathVariable String course_id, @PathVariable int student_id, HttpServletRequest httpServletRequest) {
        if ((int) httpServletRequest.getAttribute("student_id") != 1) {
            throw new NoPrivilegeException("No Privilege!");
        }
        courseService.addStudent(course_id, student_id);
        return "Success!";
    }

    @GetMapping("/courses/{course_id}/registered")
    public List<Student> registeredStudent(@PathVariable String course_id, HttpServletRequest httpServletRequest) {
        if ((int) httpServletRequest.getAttribute("student_id") != 1) {
            throw new NoPrivilegeException("No Privilege!");
        }
        return courseService.registeredStudent(course_id);
    }


}
