package com.changzh.courseregistration.dao;

import com.changzh.courseregistration.entity.Course;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO{

    private EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Course> query = session.createQuery("from Course ", Course.class);
        return query.getResultList();
    }

    @Override
    public Course find(String courseID) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Course.class, courseID);
    }

    @Override
    public void save(Course course) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(course);
    }

    @Override
    public void delete(String courseID) {
        Session session = entityManager.unwrap(Session.class);
        Query<Course> query = session.createQuery("delete from Course where course_id=:id");
        query.setParameter("id", courseID);
        query.executeUpdate();
    }
}
