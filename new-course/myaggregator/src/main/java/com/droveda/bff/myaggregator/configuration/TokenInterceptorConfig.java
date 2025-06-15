package com.droveda.bff.myaggregator.configuration;

import com.droveda.bff.myaggregator.interceptor.BearerToken;
import com.droveda.bff.myaggregator.interceptor.BearerTokenDecoder;
import com.droveda.bff.myaggregator.interceptor.MyBearerToken;
import com.droveda.bff.myaggregator.interceptor.MyTokenDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration(proxyBeanMethods = false)
public class TokenInterceptorConfig {

    @Bean
    @RequestScope
    public BearerToken bearerToken() {
        return new MyBearerToken();
    }

    @Bean
    @RequestScope
    public BearerTokenDecoder<BearerToken, String> bearerTokenDecoder(BearerToken bearerToken) {
        return new MyTokenDecoder(bearerToken);
    }

}
