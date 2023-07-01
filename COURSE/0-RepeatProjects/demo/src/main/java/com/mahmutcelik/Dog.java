package com.mahmutcelik;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{
    private DogProperties dogProperties;

    @Autowired
    public Dog(DogProperties dogProperties){
        this.dogProperties = dogProperties;
    }

    @Override
    public void sayMyName() {
        System.out.println("DOG'S NAME IS: "+ dogProperties.getName());
    }

    @Override
    public void printInformations() {
        System.out.println("---DOG'S INFORMATIONS--- :");
        dogProperties.getInfoList().forEach(e-> System.out.println("INFORMATION: "+ e));
    }


    @Override
    public void execute(){
        sayMyName();
        printInformations();
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("BEAN WILL DESTROY");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("BEAN HAS BEEN INITIALIZED");
    }

}
