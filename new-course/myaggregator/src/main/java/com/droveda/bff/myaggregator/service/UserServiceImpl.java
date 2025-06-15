package com.droveda.bff.myaggregator.service;

import com.droveda.bff.myaggregator.dto.UserDTO;
import com.droveda.bff.myaggregator.exception.InfraServiceException;
import com.droveda.bff.myaggregator.exception.UserNotFoundException;
import com.droveda.bff.myaggregator.gateway.UsersClient;
import com.droveda.bff.myaggregator.util.AppUtils;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UsersClient usersClient;

    public UserServiceImpl(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    @Override
    public UserDTO getUser(Integer id) {
        try {
            log.info("current service instance - {}", this);
            AppUtils.sleepForSeconds(3);
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
