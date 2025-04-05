package com.droveda.myrestapi.service;

import com.droveda.myrestapi.model.Todo;
import com.droveda.myrestapi.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findByUserName(String username) {
        return todoRepository.findByUsername(username);
    }

    public Todo findById(Integer id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        var todo = new Todo(
                null,
                username,
                description,
                targetDate,
                done
        );
        return todoRepository.save(todo);
    }

    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }

    public void updateTodo(Integer id, Todo todo) {
        todoRepository.save(todo);
    }
}
