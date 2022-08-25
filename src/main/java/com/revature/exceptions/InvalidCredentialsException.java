package com.revature.exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String username, String password){
        super("Failed attempt to login to user: " + username + " with password: " + password);
    }
}
