package com.droveda.a01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {

    private final ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some initialization logic...");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Doing something here...");
    }
}

@ComponentScan
public class LazyInitializationExampleMain {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(LazyInitializationExampleMain.class)) {

            System.out.println("Initialization of context is completed");

            context.getBean(ClassB.class).doSomething();

        }

    }

}
