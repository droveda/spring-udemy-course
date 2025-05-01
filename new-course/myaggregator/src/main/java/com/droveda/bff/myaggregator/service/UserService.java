package com.droveda.bff.myaggregator.service;

import com.droveda.bff.myaggregator.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUser(Integer id);

    List<UserDTO> getUsers();

}
