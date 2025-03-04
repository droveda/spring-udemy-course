package com.droveda.learn_spring_framework2;

import com.droveda.learn_spring_framework2.exercise.BusinessService;
import com.droveda.learn_spring_framework2.game.GameRunner;
import com.droveda.learn_spring_framework2.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class GamingAppLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {

            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

            context.getBean(BusinessService.class).calc();

        }

    }

}
