package com.changzh.courseregistration.controller;

import com.changzh.courseregistration.entity.Course;
import com.changzh.courseregistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/courses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @RequestMapping("/courses/{courseID}")
    public Course find(@PathVariable String courseID) {
        Course course = courseService.find(courseID);
        if (course == null) {
            throw new RuntimeException(String.format("Course: %s not found!", courseID));
        }
        return course;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        courseService.save(course);
        return course;

    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        courseService.save(course);
        return course;
    }

    @DeleteMapping("/courses/{courseID}")
    public String deleteCourse(@PathVariable String courseID) {
        Course course = courseService.find(courseID);
        if (course == null) {
            throw new RuntimeException(String.format("Course: %s not found!", courseID));
        }
        courseService.delete(courseID);
        return "Deleted!";
    }


}
