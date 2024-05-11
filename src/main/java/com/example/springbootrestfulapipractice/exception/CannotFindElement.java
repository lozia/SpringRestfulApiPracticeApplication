package com.example.springbootrestfulapipractice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CannotFindElement extends RuntimeException{
    public CannotFindElement(String msg){
        super(msg);
    }
}
