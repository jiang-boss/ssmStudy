package com.jiang.exception;

/**
 * @author jiangboss
 * @create 2021-05-16-17:46
 * 当用户的年龄出现异常的时候抛出异常
 */
public class AgeException extends MyUserException {
    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}
