package com.droveda.springin5steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeExternalService {

    @Value("${external.service.url}")
    private String url;

    public String getUrl() {
        return url;
    }
}
