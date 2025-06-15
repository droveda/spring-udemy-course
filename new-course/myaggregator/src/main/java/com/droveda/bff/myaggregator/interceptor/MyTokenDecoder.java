package com.droveda.bff.myaggregator.interceptor;

public class MyTokenDecoder implements BearerTokenDecoder<BearerToken, String> {

    private final BearerToken token;

    public MyTokenDecoder(BearerToken token) {
        this.token = token;
    }

    @Override
    public BearerToken token() {
        return token;
    }

    @Override
    public void decode(String value) {
        this.token.setToken(value);
    }
}
