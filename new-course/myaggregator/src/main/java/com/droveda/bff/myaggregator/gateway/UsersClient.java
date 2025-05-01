package com.droveda.bff.myaggregator.gateway;

import com.droveda.bff.myaggregator.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "users", url = "${users-service.url}")
public interface UsersClient {

    @GetMapping("/users/{id}")
    UserDTO getUser(@PathVariable("id") Integer id);

    @GetMapping("/users")
    List<UserDTO> getUsers();

}
