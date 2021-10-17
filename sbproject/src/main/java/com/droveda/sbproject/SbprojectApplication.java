package com.droveda.sbproject;

import com.droveda.sbproject.service.BusinessService;
import com.droveda.sbproject.service.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbprojectApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(SbprojectApplication.class);

    @Autowired
    BusinessService businessService;

    @Autowired
    BusinessService2 businessService2;

    public static void main(String[] args) {
        SpringApplication.run(SbprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info(businessService.calculateSomething());
        LOG.info(businessService2.calculateSomething());
    }
}
