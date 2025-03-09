package com.droveda.myfirstwebbapp.service;

import com.droveda.myfirstwebbapp.model.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static final List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "in28minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn DEVOPS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28minutes", "Learn Kubernetes", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream().filter(t -> t.getUsername().equalsIgnoreCase(username)).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
        todos.add(todo);
    }

    public void deleteById(int id) {
        todos.removeIf(p -> p.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
