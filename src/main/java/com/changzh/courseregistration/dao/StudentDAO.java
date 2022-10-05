package com.changzh.courseregistration.dao;

import com.changzh.courseregistration.entity.Student;

import java.util.List;

public interface StudentDAO {

    public List<Student> findAll();

    public Student find(int studentID);

    public void save(Student student);

    public void delete(int studentID);
}
