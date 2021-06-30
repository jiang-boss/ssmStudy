package com.jiang.exception;

/**
 * @author jiangboss
 * @create 2021-05-16-17:45
 *自定义的异常类  当用户的姓名有异常就抛出异常
 */
public class NameException extends MyUserException{
    public NameException() {
    }

    public NameException(String message) {
        super(message);
    }
}
