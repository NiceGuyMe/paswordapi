package com.project.paswordapi.Exception;

public class DatabaseAccessException  extends RuntimeException{
    public DatabaseAccessException(String message) {
        super(message);
    }
}
