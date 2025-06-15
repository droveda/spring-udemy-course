package com.droveda.bff.myaggregator.interceptor;

public class MyBearerToken implements BearerToken {

    private String token;

    @Override
    public String token() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

}
