package com.springlearning.learnspringframework.beanlifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    @Autowired
    private SomeDependencyClass someDependencyClass;
    public SomeClass(){
        super();

        System.out.println("All Dependencies loaded");
    }

    @PostConstruct
    public void initialize(){
        someDependencyClass.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Clean up!");
    }
}

@Component
class SomeDependencyClass {
    private int count = 0;

    public void getReady(){
        this.count++;
        System.out.println("Dependency in ready to use!");
        System.out.println(this.count);
    }
}

@Configuration
@ComponentScan
public class BeanLifeCycle {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(BeanLifeCycle.class)){
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            context.getBean(SomeClass.class).initialize();
        }
    }
}
