package com.jiang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author jiangboss
 * @create 2021-05-16-17:44
 */
public class MyUserException extends Exception{
    public MyUserException() {
    }

    public MyUserException(String message) {
        super(message);
    }
}
