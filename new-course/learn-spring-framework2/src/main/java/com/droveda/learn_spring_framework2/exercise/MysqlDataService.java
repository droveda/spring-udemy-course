package com.droveda.learn_spring_framework2.exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysqlQualifier")
public class MysqlDataService implements DataService {

    @Override
    public int[] retrieve() {
        return new int[]{1, 2, 3};
    }

}
