package com.changzh.courseregistration.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "courseID")
    private int courseID;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "capacity")
    private int capacity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "courseID"), inverseJoinColumns = @JoinColumn(name = "studentID"))
    private List<Student> students;

    public Course() {
    }

    public Course(int courseID, String title, String description, String instructor, int capacity) {
        this.courseID = courseID;
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.capacity = capacity;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructor='" + instructor + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
