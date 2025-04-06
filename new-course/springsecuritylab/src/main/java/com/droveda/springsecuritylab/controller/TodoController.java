package com.droveda.springsecuritylab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);

    public static final List<Todo> TODOS = List.of(
            new Todo("in28minutes", "Learn AWS"),
            new Todo("in28minutes", "Learn Azure")
    );

    @GetMapping("/todos")
    public List<Todo> todos() {
        return TODOS;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveForUser(@PathVariable String username) {
        return TODOS.stream()
                .filter(t -> t.username().equalsIgnoreCase(username))
                .toList();
    }

    @PostMapping("/users/{username}/todos")
    public Todo addTodo(@PathVariable String username, @RequestBody Todo todo) {
        log.info("Adding todo {}, for user {}", todo, username);
        return todo;
    }

}

record Todo(String username, String description) {
}
