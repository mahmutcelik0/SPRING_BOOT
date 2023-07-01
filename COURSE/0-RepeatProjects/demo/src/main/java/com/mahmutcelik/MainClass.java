package com.mahmutcelik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);

        context.getBean(Dog.class).execute();

        context.getBean(Cat.class).execute();

        //context.getBean(Animal.class).execute();
    }

}
