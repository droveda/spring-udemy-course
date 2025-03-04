package com.droveda.learn_spring_framework2.exercise;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessService {

    private final DataService dataService;

    public BusinessService(DataService dataService) {
        this.dataService = dataService;
    }

    public void calc() {
        System.out.println(Arrays.stream(dataService.retrieve()).max().orElse(0));
    }
}
