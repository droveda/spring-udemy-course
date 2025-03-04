package com.droveda.learn_spring_framework2.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDBDataService implements DataService {

    @Override
    public int[] retrieve() {
        return new int[]{4, 5, 6};
    }

}
