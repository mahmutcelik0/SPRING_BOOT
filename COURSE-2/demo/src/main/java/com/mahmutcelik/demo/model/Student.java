package com.mahmutcelik.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean isActive;
}
