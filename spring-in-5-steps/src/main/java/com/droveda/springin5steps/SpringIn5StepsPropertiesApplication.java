package com.droveda.springin5steps;

import com.droveda.springin5steps.properties.SomeExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.droveda.springin5steps")
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsPropertiesApplication.class);

//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringIn5StepsPropertiesApplication.class);
//
//        SomeExternalService service = context.getBean(SomeExternalService.class);
//        LOGGER.info("my value -> {} ", service.getUrl());
//
//        context.close();
//    }

}
