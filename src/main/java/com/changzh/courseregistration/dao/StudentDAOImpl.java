package com.changzh.courseregistration.dao;

import com.changzh.courseregistration.entity.Course;
import com.changzh.courseregistration.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Student> query = session.createQuery("from Student ", Student.class);
        return query.getResultList();
    }

    @Override
    public Student find(int studentID) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Student.class, studentID);
    }

    @Override
    public void save(Student student) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(student);

    }

    @Override
    public void delete(int studentID) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Student where student_id=:studentID");
        query.setParameter("studentID", studentID);
        query.executeUpdate();
    }

    @Override
    public void addCourse(int studentID, String courseID) {
        Session session = entityManager.unwrap(Session.class);
        Student student = session.get(Student.class, studentID);
        Course course = session.get(Course.class, courseID);
        student.addCourse(course);
    }

}
