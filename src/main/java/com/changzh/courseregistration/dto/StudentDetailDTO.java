package com.changzh.courseregistration.dto;


import com.changzh.courseregistration.entity.Student;

public class StudentDetailDTO {

    private int student_id;

    private String first_name;

    private String last_name;

    private String email;

    private int year_level;

    private String major;

    private String password;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYear_level() {
        return year_level;
    }

    public void setYear_level(int year_level) {
        this.year_level = year_level;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student daoMapper() {
        Student student = new Student(this.first_name, this.last_name, this.email, this.year_level, this.major, this.password);
        student.setStudent_id(this.student_id);
        return student;
    }
}
