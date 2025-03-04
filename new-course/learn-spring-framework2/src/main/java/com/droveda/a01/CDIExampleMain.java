package com.droveda.a01;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@Named
class BusinessService {

    @Inject
    private DataService dataService;


    public void doSomething() {
        System.out.println("Doing something with my dependency " + dataService);
    }

}

@Named
class DataService {

}

@ComponentScan
public class CDIExampleMain {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(CDIExampleMain.class)) {

            System.out.println("Initialization of context is completed");

            context.getBean(BusinessService.class).doSomething();

        }

    }

}
