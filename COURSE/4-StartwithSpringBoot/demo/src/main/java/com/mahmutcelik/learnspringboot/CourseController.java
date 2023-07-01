package com.mahmutcelik.learnspringboot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    /**
     * RETURN OLARAK LIST DONDURUYORUZ FAKAT SPRING BOOT UN BIZE SAGLADIGI FAYDALARDAN BIRI OLAN
     * JSON CONVERSION SAYESINDE LIST JSON FORMATINA DONUSTURULUYOR VE POSTMANDE BAKTIGIMIZ ZAMAN LIST I
     * JSON HALINDE GORUYORUZ
      [
         {
            "id": 1,
              "name": "Learn SPRING BOOT",
              "author": "MAHMUT CELIK"
        },
        {
            "id": 2,
            "name": "Learn HTML",
            "author": "ELA CELIK"
        }
      ]
     * */
    @RequestMapping("/request")
    public List<Course> retrieveAllCourses() {
        return new ArrayList<>(List.of(new Course[]{
                new Course(1, "Learn SPRING BOOT", "MAHMUT CELIK"),
                new Course(1, "Learn SPRING BOOT", "MAHMUT CELIK"),
                new Course(2, "Learn HTML", "ELA CELIK")}));
    }
}
