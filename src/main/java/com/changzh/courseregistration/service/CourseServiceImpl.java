package com.changzh.courseregistration.service;

import com.changzh.courseregistration.dao.CourseDAO;
import com.changzh.courseregistration.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseDAO courseDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
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
}
