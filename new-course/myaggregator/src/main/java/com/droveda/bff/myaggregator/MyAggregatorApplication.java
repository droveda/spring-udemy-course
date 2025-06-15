package com.droveda.bff.myaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MyAggregatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAggregatorApplication.class, args);
    }

}
