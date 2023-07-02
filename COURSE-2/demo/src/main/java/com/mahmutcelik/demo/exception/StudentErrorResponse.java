package com.mahmutcelik.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
