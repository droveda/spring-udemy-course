package com.droveda.springin5steps;

import com.droveda.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.droveda.componentscan")
public class SpringIn5StepsComponentScanApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);

//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringIn5StepsComponentScanApplication.class, args);
//
//        ComponentDAO componentDAO = context.getBean(ComponentDAO.class);
//        LOGGER.info("{}", componentDAO);
//    }


}
