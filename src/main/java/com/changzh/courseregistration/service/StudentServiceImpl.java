package com.changzh.courseregistration.service;

import com.changzh.courseregistration.dao.StudentDAO;
import com.changzh.courseregistration.entity.Course;
import com.changzh.courseregistration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student find(int student_id) {
        return studentDAO.find(student_id);
    }

    @Override
    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Override
    @Transactional
    public void delete(int student_id) {
        studentDAO.delete(student_id);
    }

    @Override
    @Transactional
    public void addCourse(int studentID, String courseID) {
        studentDAO.addCourse(studentID, courseID);
    }

    @Override
    public List<Course> enrolledCourse(int studentID) {
        return studentDAO.enrolledCourse(studentID);
    }


}
