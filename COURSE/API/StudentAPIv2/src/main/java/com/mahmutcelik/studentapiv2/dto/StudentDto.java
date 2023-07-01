package com.mahmutcelik.studentapiv2.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {
    private String firstName;
    private Long schoolNumber;
    private Long phoneNumber;
    private String cityName;
    private String townName;
}
