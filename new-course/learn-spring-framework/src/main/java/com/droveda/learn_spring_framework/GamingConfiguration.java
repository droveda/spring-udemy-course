package com.droveda.learn_spring_framework;

import com.droveda.learn_spring_framework.game.GameRunner;
import com.droveda.learn_spring_framework.game.GamingConsole;
import com.droveda.learn_spring_framework.game.PacManGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        return new PacManGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole gamingConsole) {
        return new GameRunner(gamingConsole);
    }

}
