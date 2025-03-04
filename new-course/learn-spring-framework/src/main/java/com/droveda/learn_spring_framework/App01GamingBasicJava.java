package com.droveda.learn_spring_framework;

import com.droveda.learn_spring_framework.game.GameRunner;
import com.droveda.learn_spring_framework.game.MarioGame;
import com.droveda.learn_spring_framework.game.PacManGame;
import com.droveda.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var superContra = new SuperContraGame();
        var game = new PacManGame(); //1: Object Creation

        var gameRunner = new GameRunner(game);
        // 2: Object Creation + Wiring of Dependencies
        // Game is a dependency of GameRunner

        gameRunner.run();
    }

}
