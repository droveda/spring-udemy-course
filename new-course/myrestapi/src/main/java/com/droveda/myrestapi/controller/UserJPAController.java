package com.droveda.myrestapi.controller;

import com.droveda.myrestapi.exception.UserNotFound;
import com.droveda.myrestapi.model.Post;
import com.droveda.myrestapi.model.User;
import com.droveda.myrestapi.repository.PostRepository;
import com.droveda.myrestapi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jpa")
public class UserJPAController {

    private final UserRepository repository;
    private final PostRepository postRepository;

    public UserJPAController(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers() {
        List<User> users = repository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFound("User not found"));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users")
    ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        var userSaved = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

    @GetMapping("/users/{id}/post")
    public List<Post> retrievePosts(@PathVariable("id") int id) {
        var user = repository.findById(id).orElseThrow(() -> new UserNotFound("User not found"));
        return user.getPosts();
    }


    @PostMapping("/users/{id}/post")
    ResponseEntity<Post> createPost(@PathVariable("id") int id, @Valid @RequestBody Post post) {
        var user = repository.findById(id).orElseThrow(() -> new UserNotFound("User not found"));
        post.setUser(user);

        var postSaved = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }


}
