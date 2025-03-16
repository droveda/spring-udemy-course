package com.droveda.aop_demo.service.business;

import com.droveda.aop_demo.aspect.annotation.TrackTime;
import com.droveda.aop_demo.service.data.DataService1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    private final DataService1 dataService1;

    public BusinessService1(DataService1 dataService1) {
        this.dataService1 = dataService1;
    }

    @TrackTime
    public int calculateMax() {
        int[] data = dataService1.getData();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        throw new RuntimeException("Something when wrong");
        return Arrays.stream(data).max().orElse(0);
    }
}
