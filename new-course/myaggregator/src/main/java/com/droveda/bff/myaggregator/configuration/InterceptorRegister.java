package com.droveda.bff.myaggregator.configuration;

import com.droveda.bff.myaggregator.interceptor.BearerTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
public class InterceptorRegister implements WebMvcConfigurer {

    private final BearerTokenInterceptor interceptor;

    public InterceptorRegister(BearerTokenInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
