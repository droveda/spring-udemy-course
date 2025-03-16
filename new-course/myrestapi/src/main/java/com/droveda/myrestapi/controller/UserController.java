package com.droveda.myrestapi.controller;

import com.droveda.myrestapi.model.User;
import com.droveda.myrestapi.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers() {
        List<User> users = userDaoService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = userDaoService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        var userSaved = userDaoService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable("id") int id) {
        userDaoService.deleteById(id);
    }


}
