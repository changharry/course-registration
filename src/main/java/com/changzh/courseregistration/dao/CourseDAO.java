package com.changzh.courseregistration.dao;

import com.changzh.courseregistration.entity.Course;
import com.changzh.courseregistration.entity.Student;

import java.util.List;

public interface CourseDAO {

    public List<Course> findAll();

    public Course find(String courseID);

    public void save(Course course);

    public void delete(String courseID);

    public void addStudent(String courseID, int studentID);

    public List<Student> registeredStudent(String courseID);
}
