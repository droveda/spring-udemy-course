package com.droveda.learn_springboot.coursejpa;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPARepository {

    private final EntityManager entityManager;

    public CourseJPARepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(CourseJPA course) {
        entityManager.merge(course);
    }

    public CourseJPA findById(long id) {
        return entityManager.find(CourseJPA.class, id);
    }

    public void deleteById(long id) {
        CourseJPA courseJPA = entityManager.find(CourseJPA.class, id);
        entityManager.refresh(courseJPA);
    }


}
