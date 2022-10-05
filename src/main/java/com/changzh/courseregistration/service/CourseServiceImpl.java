package com.changzh.courseregistration.service;

import com.changzh.courseregistration.dao.CourseDAO;
import com.changzh.courseregistration.dao.StudentDAO;
import com.changzh.courseregistration.entity.Course;
import com.changzh.courseregistration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseDAO courseDAO;

    private StudentDAO studentDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    @Transactional
    public Course find(String courseID) {
        return courseDAO.find(courseID);
    }

    @Override
    @Transactional
    public void save(Course course) {
        courseDAO.save(course);
    }

    @Override
    @Transactional
    public void delete(String courseID) {
        courseDAO.delete(courseID);
    }

    @Override
    @Transactional
    public void addStudent(String courseID, int studentID) {
        Course course = courseDAO.find(courseID);
        Student student = studentDAO.find(studentID);
        if (course == null) {
            throw new RuntimeException(String.format("Course: %s not found!", courseID));
        }
        if (student == null) {
            throw new RuntimeException(String.format("Student: %s not found!", studentID));
        }
        courseDAO.addStudent(courseID, studentID);
    }

    @Override
    @Transactional
    public List<Student> registeredStudent(String courseID) {
        Course course = courseDAO.find(courseID);
        if (course == null) {
            throw new RuntimeException(String.format("Course: %s not found!", courseID));
        }
        return courseDAO.registeredStudent(courseID);
    }
}
