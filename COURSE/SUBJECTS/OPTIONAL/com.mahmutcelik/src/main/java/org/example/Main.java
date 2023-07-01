package org.example;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Main {
    public static void main(String[] args){

        getStudent().forEach(s-> s.map(Student::getId).orElseThrow());



    }



    public static List<Optional<Student>> getStudent(){
        List<Optional<Student>> list = new ArrayList<>();

        list.add(Optional.ofNullable(new Student(1,"aa","aa")));
        list.add(Optional.ofNullable(null));

        return list;
    }


}