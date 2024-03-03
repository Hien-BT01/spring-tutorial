package com.springlearning.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component("MarioGame")
public class MarioGame implements GameConsole {
    public void up(){
        System.out.println("Jump");
    }

    public void down(){
        System.out.println("Go into a hole");
    }

    public void left(){
        System.out.println("Go back");
    }

    public void right(){
        System.out.println("Accelerate");
    }
}
