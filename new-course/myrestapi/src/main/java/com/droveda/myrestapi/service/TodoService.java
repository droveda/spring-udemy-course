package com.droveda.myrestapi.service;

import com.droveda.myrestapi.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "Adam", "Learn AWS", LocalDate.now().plusYears(11), false));
        todos.add(new Todo(++todosCount, "Mike", "Learn DevOps", LocalDate.now().plusYears(11), false));
        todos.add(new Todo(++todosCount, "Mike", "Learn Azure", LocalDate.now().plusYears(12), false));
    }

    public List<Todo> findByUserName(String username) {
        return todos.stream()
                .filter(t -> t.username().equalsIgnoreCase(username))
                .toList();
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
        return todo;
    }

}
