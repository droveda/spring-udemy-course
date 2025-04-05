package com.droveda.myrestapi.controller;

import com.droveda.myrestapi.model.Todo;
import com.droveda.myrestapi.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public ResponseEntity<List<Todo>> retrieveTodos(@PathVariable String username) {
        var todos = todoService.findByUserName(username);

        return ResponseEntity.ok(todos);
    }


    @GetMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> retrieveTodo(@PathVariable String username, @PathVariable int id) {
        return ResponseEntity.ok(todoService.findById(id));

    }


    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> insertTodo(@PathVariable String username, @RequestBody Todo todo) {
        var createdTodo = todoService.addTodo(username,
                todo.getDescription(),
                todo.getTargetDate(),
                todo.isDone());
        return ResponseEntity.ok(createdTodo);

    }


    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable Integer id, @RequestBody Todo todo) {
        todoService.updateTodo(id, todo);
        return ResponseEntity.ok(todo);

    }

}
