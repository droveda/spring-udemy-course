package com.droveda.bff.myaggregator.controller;

import com.droveda.bff.myaggregator.configuration.TokenInterceptorConfig;
import com.droveda.bff.myaggregator.dto.UserDTO;
import com.droveda.bff.myaggregator.exception.UserNotFoundException;
import com.droveda.bff.myaggregator.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UserController.class,
        includeFilters = {@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = TokenInterceptorConfig.class
        )})
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testListUsers() throws Exception {
        when(userService.getUsers())
                .thenReturn(
                        List.of(new UserDTO(123, "Robert", "robert@email.com", LocalDate.now()))
                );

        mockMvc.perform(
                        get("/users").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("Robert"));
    }

    @Test
    public void testGetUserById() throws Exception {
        when(userService.getUser(124))
                .thenReturn(
                        new UserDTO(124, "John Locke", "john.locke@email.com", LocalDate.now())
                );

        mockMvc.perform(
                        get("/users/124").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Locke"));
    }

    @Test
    public void testGetUserByIdNotFound() throws Exception {
        when(userService.getUser(222)).thenThrow(new UserNotFoundException("User not found with id: 222"));

        mockMvc.perform(
                        get("/users/222").contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("User not found with id: 222"));
    }

    @Test
    public void testCreateUser() throws Exception {
        var request = new UserDTO(333, "John Doe", "john.doe@gmail.com", LocalDate.now());

        mockMvc.perform(
                        post("/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))

                ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"));

    }

    @Test
    public void testCreateUserInvalidPayload() throws Exception {
        var request = new UserDTO(444, "John Doe", "john", LocalDate.now());

        mockMvc.perform(
                        post("/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request))

                ).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.detail").value("Invalid request"));

    }


}
