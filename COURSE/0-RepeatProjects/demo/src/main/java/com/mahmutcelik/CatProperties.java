package com.mahmutcelik;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//CLASS TA FIELD VARSA BUNU TANIMLARKEN SIKINTI OLUSABILIYOR BUNDAN DOLAYI DEFAULT CONSTRUCTOR KULLANDIK
@Component
public class CatProperties implements Properties{
    private String name;
    private String info1;

    public CatProperties(String name, String info1) {
        this.name = name;
        this.info1 = info1;
    }

    public CatProperties() {
        this("AA","BB");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<String> getInfoList() {
        return Arrays.asList(info1);
    }
}

