package com.example.TaskApp.exceptions.user;

import com.example.TaskApp.exceptions.BaseException;

public class UserAlreadyExistException extends BaseException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
