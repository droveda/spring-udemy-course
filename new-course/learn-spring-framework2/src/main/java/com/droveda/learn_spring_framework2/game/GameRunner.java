package com.droveda.learn_spring_framework2.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    private final GamingConsole game;

    public GameRunner(@Qualifier("superContraQualifier") GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running the game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();

    }
}
