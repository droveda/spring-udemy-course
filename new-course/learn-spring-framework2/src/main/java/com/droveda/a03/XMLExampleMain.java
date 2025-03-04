package com.droveda.a03;

import com.droveda.a03.test123.MyClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class XMLExampleMain {

    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("classpath:contextConfiguration.xml")) {

            System.out.println("Initialization of context is completed");

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            Object name = context.getBean("name");
            System.out.println(name);

            MyClass bean = context.getBean(MyClass.class);
        }

    }

}
