package com.droveda.learn_springboot.coursejpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<CourseJPA, Long> {

    List<CourseJPA> findByAuthor(String author);

}
