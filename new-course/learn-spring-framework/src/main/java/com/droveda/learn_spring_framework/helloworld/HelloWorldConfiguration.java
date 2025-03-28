package com.droveda.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {

};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Droveda";
    }

    @Bean
    public int age() {
        return 35;
    }

    @Bean
    public Person person() {
        return new Person("Some name", 25, new Address("Some address", "Some city"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address2qualifier") Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address2) {
        return new Person(name, age, address2);
    }

    @Bean(name = "customAddress")
    @Primary
    public Address address() {
        return new Address("Backer Street", "London");
    }

    @Bean
    @Qualifier("address2qualifier")
    public Address address2() {
        return new Address("Street ABC", "City A");
    }

}
