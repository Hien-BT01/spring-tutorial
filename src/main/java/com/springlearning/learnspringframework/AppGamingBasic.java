package com.springlearning.learnspringframework;

import com.springlearning.learnspringframework.game.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.springlearning.learnspringframework.game")
public class AppGamingBasic {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(AppGamingBasic.class)){
//            context.getBean(PacmanGame.class).up();
            context.getBean( GameRunner.class).run();
        }
    }
}
