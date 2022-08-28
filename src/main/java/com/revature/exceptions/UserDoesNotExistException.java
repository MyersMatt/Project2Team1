package com.revature.exceptions;

public class UserDoesNotExistException extends RuntimeException {

	public UserDoesNotExistException() {
		
		super ("The specified user does not exist.");

	}

}
