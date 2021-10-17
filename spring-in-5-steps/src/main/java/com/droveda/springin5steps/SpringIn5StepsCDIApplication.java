package com.droveda.springin5steps;

import com.droveda.springin5steps.cdi.SomeCDIBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIn5StepsCDIApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCDIApplication.class);

//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringIn5StepsCDIApplication.class, args);
//
//        SomeCDIBusiness cdiBusiness = context.getBean(SomeCDIBusiness.class);
//
//        LOGGER.info("{}", cdiBusiness);
//        LOGGER.info("{}", cdiBusiness.getSomeCdiDao());
//
//    }


}
