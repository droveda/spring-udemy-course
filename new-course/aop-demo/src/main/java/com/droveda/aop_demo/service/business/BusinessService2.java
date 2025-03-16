package com.droveda.aop_demo.service.business;

import com.droveda.aop_demo.service.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {

    private final DataService1 dataService1;

    public BusinessService2(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    public int calculateMin() {
        int[] data = dataService1.getData();


//        throw new RuntimeException("Something when wrong");
        return Arrays.stream(data).min().orElse(0);
    }
}
