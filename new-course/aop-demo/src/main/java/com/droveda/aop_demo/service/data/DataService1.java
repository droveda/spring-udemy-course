package com.droveda.aop_demo.service.data;

import org.springframework.stereotype.Service;

@Service
public class DataService1 {

    public int[] getData() {
        return new int[]{
                11, 22, 33, 44, 55
        };
    }

}
