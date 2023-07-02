package com.mahmut.celik.employeeproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
