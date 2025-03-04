package com.droveda.learn_springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {

        return ResponseEntity.ok(List.of(
                new Course(1, "Learn AWS", "in28Minutes"),
                new Course(2, "Learn DevOps", "in28Minutes"),
                new Course(3, "Learn Azure", "in28Minutes"),
                new Course(4, "Learn Kubernetes", "in28Minutes")
        ));

    }

}
