package com.droveda.service;

public class UserValidationService {

    public boolean validate(String user, String password) {
        return user.equals("droveda") && password.equals("password");
    }

}
