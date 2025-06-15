package com.droveda.bff.myaggregator.interceptor;

public interface BearerTokenDecoder<T, U> {

    T token();

    void decode(U value);

}
