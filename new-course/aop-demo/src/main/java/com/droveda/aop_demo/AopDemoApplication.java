package com.droveda.aop_demo;

import com.droveda.aop_demo.service.business.BusinessService1;
import com.droveda.aop_demo.service.business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(AopDemoApplication.class);

    @Autowired
    private BusinessService1 businessService1;

    @Autowired
    private BusinessService2 businessService2;

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Value returned is: {}", businessService1.calculateMax());
        log.info("Value returned is: {}", businessService2.calculateMin());

    }
}
