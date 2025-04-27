package com.droveda.bff.myaggregator.controller;

import com.droveda.bff.myaggregator.dto.UserDTO;
import com.droveda.bff.myaggregator.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
        return ResponseEntity.ok(List.of(new UserDTO(1, "John Doe", "john.doe@company.com", LocalDate.now())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(
                userService.getUser(id)
        );
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDTO.id())
                .toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }


}
