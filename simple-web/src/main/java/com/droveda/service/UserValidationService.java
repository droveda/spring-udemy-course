package com.droveda.service;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    public boolean validate(String user, String password) {
        return user.equals("droveda") && password.equals("password");
    }

}
