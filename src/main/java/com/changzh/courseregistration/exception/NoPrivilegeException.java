package com.changzh.courseregistration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NoPrivilegeException extends RuntimeException{
    public NoPrivilegeException(String message) {
        super(message);
    }
}
