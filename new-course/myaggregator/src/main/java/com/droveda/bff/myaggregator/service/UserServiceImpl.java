package com.droveda.bff.myaggregator.service;

import com.droveda.bff.myaggregator.dto.UserDTO;
import com.droveda.bff.myaggregator.exception.InfraServiceException;
import com.droveda.bff.myaggregator.exception.UserNotFoundException;
import com.droveda.bff.myaggregator.gateway.UsersClient;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UsersClient usersClient;

    public UserServiceImpl(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    @Override
    public UserDTO getUser(Integer id) {
        try {
            return usersClient.getUser(id);
        } catch (FeignException.NotFound ex) {
            throw new UserNotFoundException("User not found with id: " + id, ex);
        } catch (FeignException ex) {
            if (ex.status() != -1) {
                throw new InfraServiceException(ex.getMessage(), ex, HttpStatus.resolve(ex.status()));
            }
            throw new InfraServiceException(ex.getMessage(), ex);
        }
    }

    @Override
    public List<UserDTO> getUsers() {
        return usersClient.getUsers();
    }
}
