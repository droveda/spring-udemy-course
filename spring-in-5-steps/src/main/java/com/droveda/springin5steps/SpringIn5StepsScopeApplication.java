package com.droveda.springin5steps;

import com.droveda.springin5steps.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIn5StepsScopeApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringIn5StepsScopeApplication.class, args);
//
//        PersonDAO personDAO = context.getBean(PersonDAO.class);
//        PersonDAO personDAO2 = context.getBean(PersonDAO.class);
//
//        LOGGER.info("{}", personDAO);
//        LOGGER.info("{}", personDAO.getJdbccOnnection());
//        LOGGER.info("{}", personDAO.getJdbccOnnection());
//
//        LOGGER.info("{}", personDAO2);
//        LOGGER.info("{}", personDAO2.getJdbccOnnection());
//    }


}
