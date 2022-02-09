package com.skypro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistsExeption extends RuntimeException {

    public EmployeeExistsExeption(String message) {
        super(message);
    }
}
