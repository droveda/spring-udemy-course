package com.droveda.bff.myaggregator.service;

import com.droveda.bff.myaggregator.dto.UserDTO;
import com.droveda.bff.myaggregator.gateway.UsersClient;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UsersClient usersClient;

    public UserServiceImpl(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    @Override
    public UserDTO getUser(Integer id) {
        return usersClient.getUser(id);
    }
}
