package com.changzh.courseregistration.dao;

import com.changzh.courseregistration.entity.Course;

import java.util.List;

public interface CourseDAO {

    public List<Course> findAll();

    public Course find(String courseID);

    public void save(Course course);

    public void delete(String courseID);
}
