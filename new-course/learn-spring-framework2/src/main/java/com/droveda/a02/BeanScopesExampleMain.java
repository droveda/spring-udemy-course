package com.droveda.a02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {

    @PostConstruct
    public void inti() {
        System.out.println("NormalClass bean created - init");
    }

    @PreDestroy
    public void finish() {
        System.out.println("Destroying normal class - cleanup");
    }

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}

@ComponentScan
public class BeanScopesExampleMain {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(BeanScopesExampleMain.class)) {

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        }

    }

}
