package com.skypro.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeArrayFullExeption extends RuntimeException{


    public EmployeeArrayFullExeption(String message) {
        super(message);
    }
}
