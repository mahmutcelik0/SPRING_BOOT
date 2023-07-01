package com.mahmutcelik;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat implements Animal{
    private CatProperties catProperties;

    @Autowired
    public Cat(CatProperties catProperties){
        this.catProperties = catProperties;
    }

    @Override
    public void sayMyName() {
        System.out.println("CAT'S NAME IS: "+ catProperties.getName());
    }

    @Override
    public void printInformations() {
        System.out.println("---CAT'S INFORMATIONS--- :");
        catProperties.getInfoList().forEach(e-> System.out.println("INFORMATION: "+ e));
    }

    @Override
    public void execute(){
        sayMyName();
        printInformations();
    }

    @PreDestroy
    public void preDestoryMethod(){
        System.out.println("BEAN WILL DESTROY");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("BEAN HAS BEEN INITIALIZED");
    }

}
