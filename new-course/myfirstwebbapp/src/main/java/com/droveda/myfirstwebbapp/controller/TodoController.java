package com.droveda.myfirstwebbapp.controller;

import com.droveda.myfirstwebbapp.model.Todo;
import com.droveda.myfirstwebbapp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        String userName = getLoggedInUserName();

        List<Todo> todos = todoService.findByUsername(userName);
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    private static String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodo(ModelMap model) {
        String userName = getLoggedInUserName();
        Todo todo = new Todo(0, userName, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        String userName = getLoggedInUserName();
        todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), todo.isDone());

        return "redirect:list-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodoPage(@RequestParam int id, ModelMap model) {
        var todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        String userName = getLoggedInUserName();
        todo.setUsername(userName);
        todoService.updateTodo(todo);

        return "redirect:list-todos";
    }

}
