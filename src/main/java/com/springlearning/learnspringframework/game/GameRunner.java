package com.springlearning.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    GameConsole game;
    public GameRunner(@Qualifier("superContraGame") GameConsole game) {
        this.game = game;
    }
    public void run (){
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
