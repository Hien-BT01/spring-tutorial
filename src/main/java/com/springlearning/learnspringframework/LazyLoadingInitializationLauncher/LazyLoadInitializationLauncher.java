package com.springlearning.learnspringframework.LazyLoadingInitializationLauncher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Arrays;



@Component
@Lazy
class ClassC{
    private ClassB classB;
    public ClassC(ClassB classB){
        this.classB = classB;
        System.out.println("Initialize class C");
        this.classB.printHelloWorld();
    }
}

@Component
@Lazy(value = true)
class ClassA{
    public ClassA(){
        System.out.println("Initialize class A");
    }
}


@Component
@Lazy
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA){
        System.out.println("Initialize class B");
        this.classA = classA;
    }

    public void printHelloWorld(){
        System.out.println("Hello world");
    }
}

@Configuration
@ComponentScan
public class LazyLoadInitializationLauncher {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(LazyLoadInitializationLauncher.class)){
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }

}
