package com.droveda.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        //1 - Launch a Spring Context
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            //2 - Configure the things that we want Spring to manage - @Configuration


            Object name = context.getBean("name");
            System.out.println(name);

            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("customAddress"));

            Address bean = context.getBean(Address.class);
            System.out.println(bean);

            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean("person5Qualifier"));

            System.out.println("----");

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }


    }

}
