package com.droveda.bff.myaggregator.service;

import com.droveda.bff.myaggregator.dto.UserDTO;

public interface UserService {

    UserDTO getUser(Integer id);

}
