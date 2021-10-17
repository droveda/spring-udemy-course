package com.droveda.springin5steps;

import com.droveda.springin5steps.basic.BinarySearchImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.droveda.springin5steps")
public class SpringIn5StepsApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringIn5StepsApplication.class);

        BinarySearchImpl binarySearch = context.getBean(BinarySearchImpl.class);

        int result = binarySearch.binarySearch(new int[]{12, 4, 6}, 3);
        System.out.println(result);
        System.out.println(binarySearch);

        context.close();
    }

}
