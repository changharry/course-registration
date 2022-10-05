package com.changzh.courseregistration.service;

import com.changzh.courseregistration.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    public Student find(int student_id);

    public void save(Student student);

    public void delete(int student_id);

    public void addCourse(int studentID, String courseID);
}
