package com.mahmutcelik;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DogProperties implements Properties{
    private String name;
    private String info1;
    private String info2;

    public DogProperties(String name, String info1,String info2){
        this.name = name;
        this.info1 = info1;
        this.info2 = info2;
    }

    public DogProperties() {
        this("CC","DD","EE");
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public List<String> getInfoList(){
        return Arrays.asList(info1, info2);

    }
}
