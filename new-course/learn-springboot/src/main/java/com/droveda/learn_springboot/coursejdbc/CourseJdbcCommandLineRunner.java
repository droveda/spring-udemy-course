package com.droveda.learn_springboot.coursejdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    private final CourseJdbcRepository repository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new CourseEntityJdbc(1, "Learn AWS", "in28Minutes"));
        repository.insert(new CourseEntityJdbc(2, "Learn Azure", "in28Minutes"));
        repository.insert(new CourseEntityJdbc(3, "Learn Kubernetes", "in28Minutes"));
        repository.insert(new CourseEntityJdbc(4, "Learn DevOps Now", "in28Minutes"));

        repository.delete(3);

        CourseEntityJdbc byId = repository.getById(2);
        System.out.println(byId);
    }
}
