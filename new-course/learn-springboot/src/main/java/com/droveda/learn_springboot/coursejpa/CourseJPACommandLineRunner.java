package com.droveda.learn_springboot.coursejpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

    private final CourseJPARepository repository;

    private final CourseRepository courseRepository;

    public CourseJPACommandLineRunner(CourseJPARepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new CourseJPA(10, "Learn AWS", "Droveda"));
        repository.insert(new CourseJPA(11, "Learn Azure", "Droveda"));
        repository.insert(new CourseJPA(12, "Learn Kubernetes", "Droveda"));
        repository.insert(new CourseJPA(13, "Learn DevOps 123", "Droveda"));

        repository.deleteById(10);

        CourseJPA byId = repository.findById(13);
        System.out.println(byId);

        courseRepository.save(new CourseJPA(15, "Learn Spring Now!!", "Droveda"));
        Optional<CourseJPA> byId1 = courseRepository.findById(15L);

        System.out.println(byId1.orElseThrow(() -> new RuntimeException("Course not found")));

        List<CourseJPA> all = courseRepository.findAll();
        all.stream().forEach(System.out::println);

        courseRepository.findByAuthor("Droveda").stream().forEach(System.out::println);

    }

}
